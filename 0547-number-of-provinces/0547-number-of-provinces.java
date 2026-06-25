class Solution {
    public int findCircleNum(int[][] Con) {

        boolean vis[] = new boolean[Con.length ]; int c =0;

        for(int i = 0;i<vis.length;i++)
        {
            if(!vis[i])
            {
                c++;
                dfs(i,vis,Con);
            }
        }
        return c;
        
        
    }
    void dfs(int n , boolean[] vis , int[][] con )
    {
        vis[n] =true;
       
        for(int i =0;i< con.length ; i++)
        {
            if(con[n][i]==1 && !vis[i])
            dfs(i,vis,con);
        }
    }
}