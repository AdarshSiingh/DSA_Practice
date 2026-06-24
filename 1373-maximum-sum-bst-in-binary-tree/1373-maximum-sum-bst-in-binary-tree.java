/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class info
 {
    boolean bst ;
    int min , max , sum ;

    info(boolean b , int mi , int ma , int s)
    {
        bst = b; min = mi ; max = ma ; sum = s;
    }
 }
class Solution {
    int ans = 0;
    public int maxSumBST(TreeNode root) {

        post(root);
        return ans;
        
    }
    info post(TreeNode root)
    {
        if(root == null)
        return new info(true,Integer.MAX_VALUE,Integer.MIN_VALUE,0);

        info l = post(root.left);
        info r = post(root.right);

        if(l.bst && r.bst && root.val > l.max && root.val < r.min)
        {
            int sum = l.sum + r.sum + root.val;
            ans = Math.max(ans , sum);

            return new info(true,Math.min(root.val,l.min),Math.max(root.val,r.max),sum);
        }

        return new info(false,0,0,0);

    }


}