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
class Solution {
    public int countNodes(TreeNode root) {

        if(root == null) return 0;

        int lh = lh(root.left);
        int rh = rh(root.right);

        if(rh == lh) return ((2<<(lh))-1);
        
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    int lh(TreeNode t)
    {
        int c = 0;
        while(t != null)
        {
            c++;
            t = t.left;
        }
        return c;
    }
    int rh(TreeNode t)
    {
        int c =0;
        while(t != null)
        {
            t = t.right;
            c++;
        }
        return c;
    }
}