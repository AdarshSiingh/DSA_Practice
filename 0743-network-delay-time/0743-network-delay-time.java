class P{
    int n , t;
    P(int nn , int tt)
    {n = nn ; t=tt;}
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
       
       List<List<P>> adj = new ArrayList<>();

       for(int i = 0; i<n+1 ;i++)
       adj.add(new ArrayList<>());

       for(int i[] : times)
       adj.get(i[0]).add(new P(i[1],i[2]));

       int dis[] = new int[n+1];  Arrays.fill(dis,Integer.MAX_VALUE);

      PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

      dis[k] = 0;
      q.add(new int[]{0,k});

      while(!q.isEmpty())
      {
        int x[] = q.remove();
        int t = x[0];
        int no = x[1];

        for(P i : adj.get(no))
        {
            int tt = i.t , node = i.n;

            if(tt + t < dis[node])
            {
                dis[node] = tt + t;
                q.add(new int[]{dis[node],node});
            }

        }
      }
      
      int max = 0 , c = 0;

     for(int i = 1; i <= n; i++)
    {
    if(dis[i] == Integer.MAX_VALUE)
        return -1;

    max = Math.max(max, dis[i]);
    } 

      return max;
        
    }
}