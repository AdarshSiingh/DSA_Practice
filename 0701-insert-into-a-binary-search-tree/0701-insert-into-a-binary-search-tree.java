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
    public TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode r = root , t = null , v = new TreeNode(val);

        if(root == null) return v;

        while(root != null)
        {
            t = root;

            if(root.val < val)
            root = root.right;

            else
            root = root.left;

        }

        if(t.val < val)
        t.right = v;
        else
        t.left = v;

        return r;
        
    }
}