class Solution {
    public List<Integer> eventualSafeNodes(int[][] g) {
        int m = g.length;
        List<Integer>  ans = new ArrayList<>();
        boolean 
        vis[] = new boolean[m],
        path[] = new boolean[m],
        safe[] = new boolean[m];

        for(int i = 0;i<m;i++)
        if(!vis[i])
        dfs(i,g,vis,path,safe);

        for(int i = 0;i<m;i++)
        if(safe[i])
        ans.add(i);

        return ans;
        
    }
    boolean dfs(int n , int[][] g , boolean vis[] , boolean path[] , boolean safe[])
    {
        vis[n] = true;
        path[n] = true;

        for(int i : g[n])
        {
            if(!vis[i]){
            if(dfs(i,g,vis,path,safe))
            return true;
            }
            else if(path[i])
            return true;
        }
        path[n] = false;
        safe[n] = true;

        return false;
    }
}