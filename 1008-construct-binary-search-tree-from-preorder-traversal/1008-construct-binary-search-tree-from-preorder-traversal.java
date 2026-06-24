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
    int i = 0;
    public TreeNode bstFromPreorder(int[] pre) {
         return build(pre,Integer.MAX_VALUE);
        
    }
    TreeNode build(int[] pre , int b)
    {
        if(i == pre.length || pre[i]>b) return null;

        TreeNode r = new TreeNode(pre[i++]);

        r.left = build(pre,r.val);
        r.right = build(pre,b);

        return r;
    }
}