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
    public TreeNode buildTree(int[] in, int[] post) {
         Map<Integer,Integer> m = new HashMap<>();
        
        for(int i =0;i<in.length;i++)
        m.put(in[i],i);

        TreeNode r = tree(post,0,post.length-1,in,0,in.length-1,m);
        return r;
        
    }
    TreeNode tree(int[] post , int ps , int pe , int[] in , int is , int ie ,Map<Integer,Integer> m )
    {
        if(ps>pe || is>ie ) return null;

        TreeNode n = new TreeNode(post[pe]);
        int inR = m.get(n.val);
        int left = inR - is;

        n.left = tree(post,ps,ps+left-1,in,is,inR-1,m);
        n.right = tree(post, ps+left, pe-1 , in , inR+1 , ie,m);

        return n;
    }
}