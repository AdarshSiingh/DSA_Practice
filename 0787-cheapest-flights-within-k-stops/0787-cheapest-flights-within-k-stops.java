class T{
    int s , n,d;
    T(int dd , int rr , int cc)
    {s=dd; n=rr ; d=cc;}
}
class P{
    int n,d;
    P(int dd , int rr )
    {n=dd; d=rr ;}
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<P>> adj = new ArrayList<>();
        Queue<T> q = new LinkedList<>();

        for(int i = 0 ; i < n ; i++)
        adj.add(new ArrayList<>());

        for(int i[] : flights)
        adj.get(i[0]).add(new P(i[1],i[2]));

        int[] dis = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);

        q.add(new T(0,src,0));
        dis[src] = 0;

        while(!q.isEmpty())
        {
            T t = q.poll();
            int s = t.s , no = t.n , d = t.d;

            if(s>k) continue;

            for(P p : adj.get(no))
            {
                int node = p.n;
                int wt = p.d;

                if(wt + d < dis[node] && s<= k)
                {
                    dis[node] = wt + d;
                    q.add(new T(s+1,node,dis[node]));
                }
            }
        }
        return (dis[dst] == Integer.MAX_VALUE ? -1 : dis[dst]);
        
        
    }
}