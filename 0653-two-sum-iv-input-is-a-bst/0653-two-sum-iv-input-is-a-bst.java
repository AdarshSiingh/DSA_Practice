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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> l = new ArrayList<>();
        in(root,l);
        int s = 0 , e = l.size()-1;

        while(s<e)
        {
            int sum = l.get(s) + l.get(e);

            if(sum == k) return true;

            if(sum < k) s++;
            else
            e--;
        }
        return false;
    }
    void in(TreeNode n , List<Integer> l)
    {
        if(n == null) return;
        in(n.left,l);
        l.add(n.val);
        in(n.right,l);
    }
}