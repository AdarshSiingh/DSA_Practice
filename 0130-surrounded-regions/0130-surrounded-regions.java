class Solution {
    void dfs(char[][] bd , int vis[][] ,int r , int c)
    {
        int n = bd.length;
        int m = bd[0].length;

        if(r<0 || c<0 || r>=n || c>=m || vis[r][c]==1 || bd[r][c]=='X') 
        return;

        vis[r][c] = 1;
        dfs(bd,vis,r-1,c);
        dfs(bd,vis,r,c+1);
        dfs(bd,vis,r+1,c);
        dfs(bd,vis,r,c-1);

      
    }
    public void solve(char[][] bd) {
        int n = bd.length;
        int m = bd[0].length;
        int vis[][] = new int[n][m];

        for(int i =0;i<m;i++)
        {
            if(bd[0][i]=='O' && vis[0][i] == 0 )
            dfs(bd,vis,0,i);

            if(bd[n-1][i]=='O' && vis[n-1][i]== 0)
            dfs(bd,vis,n-1,i);
        }
        for(int i = 0 ; i<n;i++)
        {
            if(bd[i][0]=='O' && vis[i][0] == 0 )
            dfs(bd,vis,i,0);

            if(bd[i][m-1]=='O' && vis[i][m-1]== 0)
            dfs(bd,vis,i,m-1);
            
        }
        
        for(int i = 0;i<n;i++)
        for(int j = 0;j<m;j++)
        {
            if(vis[i][j]!=1)
            bd[i][j] = 'X';
        }
      

        
    }
}