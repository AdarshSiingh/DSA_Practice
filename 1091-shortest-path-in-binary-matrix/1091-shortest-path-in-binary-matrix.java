class T{
    int d , r,c;
    T(int dd , int rr , int cc)
    {d=dd; r=rr ; c=cc;}
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] g) {

        int n = g.length , m = g[0].length;

        if(g[0][0] == 1 || g[n-1][m-1]==1) return -1;

        int dis[][] = new int[g.length][g[0].length];

        for(int i = 0 ; i < n ; i++)
        for(int j = 0 ; j<m ; j++)
        dis[i][j] = Integer.MAX_VALUE;

        Queue<T> q = new LinkedList<>();
        q.add(new T(1,0,0));
        dis[0][0] = 1;

        while(!q.isEmpty())
        {
            T t = q.poll();
            int d = t.d ,
            r = t.r , c = t.c;

            for(int dr = -1 ; dr<=1 ; dr++)
            for(int dc = -1 ; dc <=1 ; dc++)
            {
                int nr = r+dr;
                int nc = c+dc;

                if(nr>= 0 && nr < n && nc >=0 && nc < m && g[nr][nc]== 0 && d+1 < dis[nr][nc])
                {
                    dis[nr][nc] = d+1;
                    q.add(new T(d+1,nr,nc));
                }
            }
        }
        return (dis[n-1][m-1] == Integer.MAX_VALUE ? -1 : dis[n-1][m-1]) ;
        
    }
}