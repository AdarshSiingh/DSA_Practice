class Solution {
    public int findTheCity(int n, int[][] edges, int T) {
    
        int[][] dis = new int[n][n];
        for(int i = 0 ; i<n;i++)
        for(int j =0;j<n;j++)
        {
            int x = (i==j) ? 0 : Integer.MAX_VALUE;
            dis[i][j] = x;
        }

        for(int i[] : edges)
        {
            int u = i[0] , v = i[1] , wt = i[2];
            dis[u][v] = dis[v][u] = wt;
        }

        for(int k = 0;k<n;k++)
        for(int i =0;i<n;i++)
        for(int j=0;j<n;j++)
        {
            if(dis[i][k] != Integer.MAX_VALUE && dis[k][j] != Integer.MAX_VALUE)
            {
                dis[i][j] = Math.min(dis[i][j] , (dis[i][k] + dis[k][j]));
            }
        }

        int city = n,
        cityno = -1,
        c =0;

        for(int i = 0;i<n;i++)
        {
            c = 0;
            for(int j =0;j<n;j++)
            {
                if(dis[i][j] <= T) c++;
            }

            c--;

            if(c <= city)
            {
                city = c;
                cityno = i;
            }

        }
        return cityno;
        
    }
}