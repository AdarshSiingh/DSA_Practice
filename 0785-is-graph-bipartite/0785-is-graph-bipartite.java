class Solution {
    public boolean isBipartite(int[][] g) {
         int n = g.length;

        int color[] = new int[n]; 
        for(int i = 0 ; i < n; i++) color[i] = -1;

        for(int i = 0 ; i < n ; i++)
        if(color[i] == -1)
        if(dfs(i,0,color,g)==false)
        return false;

        return true;
    }
    boolean dfs(int n , int c , int[] col , int[][] g)
    {
        int m = g.length;
        col[n] = c;

        for(int i : g[n])
        {
            if(col[i]==-1)
            {
            if(dfs(i,1-c,col,g)==false)
            return false;
            }
            else if(col[i]==col[n])
            return false;

        }
        return true;
    }
}