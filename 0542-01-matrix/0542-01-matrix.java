class T
{
    int r , c , t;
    T(int rr , int cc , int tt)
    {
        r = rr; c = cc; t = tt;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] g) {
        int n = g.length;
        int m = g[0].length;
        int[][] ans = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<T> q = new LinkedList<>();
        for(int i = 0;i<n;i++)
        for(int j =0;j<m;j++)
        if(g[i][j] == 0)
        {
        q.add(new T(i,j,0)); 
        vis[i][j] = true;
        }

        int dr[] = {-1,0,1,0};
        int dc[] = {0,1,0,-1};

        while(!q.isEmpty())
        {
            T x = q.remove();
            int r = x.r;
            int c = x.c;
            int t = x.t;
            
            ans[r][c] = t;

            for(int k = 0;k<4;k++)
            {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr>= 0 && nr<n && nc>= 0 && nc<m && !vis[nr][nc] )
                {
                    q.add(new T(nr,nc,t+1));
                    vis[nr][nc] = true;
                }
            }

        }
        return ans;
    }
}