/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null;

        int r = root.val , pp = p.val , qq = q.val;

        if(r>pp && r>qq)  return lowestCommonAncestor(root.left,p,q);

        if(r<pp && r<qq)  return lowestCommonAncestor(root.right,p,q);

        return root;
        
    }

}