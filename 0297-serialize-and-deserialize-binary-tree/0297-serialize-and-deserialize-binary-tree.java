/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder s = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode c = q.remove();
            if( c == null)
           {  s.append("n "); continue ; }
            else
            s.append(c.val + " ");

            q.add(c.left); q.add(c.right);
        }
        return s.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        String s[] = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode r = new TreeNode(Integer.parseInt(s[0]));
        q.add(r);

        for(int i = 1 ; i < s.length; i++)
        {
            TreeNode c = q.remove();
            if(!s[i].equals("n"))
            {
                TreeNode n = new TreeNode(Integer.parseInt(s[i]));
                c.left = n;
                q.add(n);
            }
            if(!s[++i].equals("n"))
            {
                TreeNode n = new TreeNode(Integer.parseInt(s[i]));
                c.right = n;
                q.add(n);
            }
        }
        return r;

        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));