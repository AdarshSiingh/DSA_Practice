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
    TreeNode f = null , m = null , l = null, p = null;
    public void recoverTree(TreeNode root) {

        in(root);

        if (l == null) {          // adjacent nodes swapped
            int temp = f.val;
            f.val = m.val;
            m.val = temp;
        } 
        else {                  // non-adjacent nodes swapped
            int temp = f.val;
            f.val = l.val;
            l.val = temp;
        }
    }
    void in(TreeNode r )
    {
        if(r == null) return;
        in(r.left);

        if(p!= null && p.val > r.val)
        {
            if(f == null)
            {
                f = p;
                m = r;
            }
            else
            l = r;
        }
        p = r;
        in(r.right);

    }

}