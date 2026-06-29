class T{
    int d , r,c;
    T(int dd , int rr , int cc)
    {d=dd; r=rr ; c=cc;}
}
class Solution {
    public int minimumEffortPath(int[][] g) {
        int n = g.length , m = g[0].length;
        int dis[][] = new int[g.length][g[0].length];
        PriorityQueue<T> q = new PriorityQueue<>((a,b) -> a.d - b.d);
        for(int i = 0 ; i < n ; i++)
        for(int j = 0 ; j<m ; j++)
        dis[i][j] = Integer.MAX_VALUE;

        q.add(new T(0,0,0));
        dis[0][0] = 0;

        int dr[] = {-1,0,1,0};
        int dc[] = {0,1,0,-1};

        while(!q.isEmpty())
        {
            T t = q.remove();
            int eff = t.d ,
            r = t.r , c = t.c;

            if(r == n-1 && c == m-1) return eff;

            for(int i = 0 ; i < 4 ; i++)
            {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr>= 0 && nr < n && nc >=0 && nc < m)
                {
                    int newE = Math.max(eff, Math.abs(g[nr][nc] - g[r][c]));

                    if(newE < dis[nr][nc])
                    {
                        dis[nr][nc] = newE;
                        q.add(new T(newE,nr,nc));
                    }
                
                }
            }
        }
        return -1;
        
    }
}