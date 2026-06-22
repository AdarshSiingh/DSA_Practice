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
    public TreeNode buildTree(int[] pre, int[] in) {
        Map<Integer,Integer> m = new HashMap<>();
        
        for(int i =0;i<in.length;i++)
        m.put(in[i],i);

        TreeNode r = tree(pre,0,pre.length-1,in,0,in.length-1,m);
        return r;
        
    }
    TreeNode tree(int[] pre , int ps , int pe , int[] in , int is , int ie ,Map<Integer,Integer> m )
    {
        if(ps>pe || is>ie ) return null;

        TreeNode n = new TreeNode(pre[ps]);
        int inR = m.get(n.val);
        int left = inR - is ;

        n.left = tree(pre,ps+1,ps+left,in,is,inR-1,m);
        n.right = tree(pre , ps+left+1, pe , in , inR+1 , ie , m);

        return n;

    }
}