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
    Map<TreeNode,TreeNode> parent(TreeNode t)
    {
        Map<TreeNode,TreeNode> m = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(t);
        while(!q.isEmpty())
        {
            TreeNode c = q.remove();

            if(c.left!=null)
            {
                m.put(c.left,c);
                q.add(c.left);
            }
            if(c.right!=null)
            {
                m.put(c.right,c);
                q.add(c.right);
            }
        }
        return m;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> l = new ArrayList<>();
        Map<TreeNode,TreeNode> m = new HashMap<>();
        Map<TreeNode,Boolean> vis = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        m = parent(root);
        q.add(target);
        vis.put(target,true);
        int count = 0;

        while(!q.isEmpty())
        {
            int s = q.size();
            
            if(count==k) break;
            count++;

            for(int i =0;i<s;i++)
            {
                TreeNode c = q.remove();

                if(c.left != null && vis.get(c.left)==null)
                {
                    q.add(c.left);
                    vis.put(c.left,true);
                }
                if(c.right != null && vis.get(c.right)==null)
                {
                    q.add(c.right);
                    vis.put(c.right,true);
                }
                if(m.get(c) != null && vis.get(m.get(c))==null)
                {
                    q.add(m.get(c));
                    vis.put(m.get(c),true);
                }
            }

        }

        while(!q.isEmpty())
        l.add(q.remove().val);
        
        return l;
    }
}