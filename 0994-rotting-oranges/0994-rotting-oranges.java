class T
{
    int r , c , t;
    T(int rr , int cc , int tt)
    {
        r = rr; c = cc; t = tt;
    }
}
class Solution {
    public int orangesRotting(int[][] g) {
        int n = g.length;
        int m = g[0].length;
        int t =0 , frsh = 0 , rot = 0;
        Queue<T> q = new LinkedList<>();
        for(int i = 0;i<n;i++)
        for(int j =0;j<m;j++)
        if(g[i][j] == 2)
        q.add(new T(i,j,0)); 
        else if(g[i][j]==1)
        frsh++;

        int dr[] = {-1,0,1,0};
        int dc[] = {0,1,0,-1};

        while(!q.isEmpty())
        {
            T x = q.remove();
            int r = x.r;
            int c = x.c;
                t = x.t;

            for(int k = 0;k<4;k++)
            {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr>= 0 && nr<n && nc>= 0 && nc<m && g[nr][nc] == 1)
                {
                    g[nr][nc]=2; rot++;
                    q.add(new T(nr,nc,t+1));
                }
            }

        }
        return (frsh == rot ? t : -1);
    }
}