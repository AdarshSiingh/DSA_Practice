class P{
    int r , c;
    P(int rr, int cc)
    { r = rr ; c = cc;}
}
class Solution {
    public int[][] floodFill(int[][] im, int sr, int sc, int color) {
        int n = im.length;
        int m = im[0].length;

        int x = im[sr][sc];
        if(x==color) return im;
        
        im[sr][sc] = color;

        Queue<P> q = new LinkedList<>();
        q.add(new P(sr,sc));

        int dr[] = {-1,0,1,0};
        int dc[] = {0,1,0,-1};

        while(!q.isEmpty())
        {
            P p = q.remove();
            int r = p.r;
            int c = p.c;

            for(int k = 0;k<4;k++)
            {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr>= 0 && nr<n && nc>= 0 && nc<m && im[nr][nc] == x)
                {
                    im[nr][nc]=color; 
                    q.add(new P(nr,nc));
                }
            }
        }
        return im;
        
    }
}