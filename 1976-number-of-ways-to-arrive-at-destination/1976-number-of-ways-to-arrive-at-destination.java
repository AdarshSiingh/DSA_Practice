class P {
    int n;
    long d;  // ← long
    P(int node, long dist) { n = node; d = dist; }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<P>> adj = new ArrayList<>();
        PriorityQueue<P> q = new PriorityQueue<>((a, b) -> Long.compare(a.d, b.d)); // ← Long.compare

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] r : roads) {
            adj.get(r[0]).add(new P(r[1], r[2]));
            adj.get(r[1]).add(new P(r[0], r[2]));  // bidirectional
        }

        long[] dis = new long[n];  // ← long[]
        int[] ways = new int[n];
        int mod = (int)(1e9 + 7);
        Arrays.fill(dis, Long.MAX_VALUE);  // ← Long.MAX_VALUE
        ways[0] = 1; dis[0] = 0;
        q.add(new P(0, 0));

        while (!q.isEmpty()) {
            P p = q.poll();
            int no = p.n; long d = p.d;

            for (P i : adj.get(no)) {
                int node = i.n; long wt = i.d;
                if (d + wt < dis[node]) {
                    dis[node] = d + wt;
                    q.add(new P(node, dis[node]));
                    ways[node] = ways[no];
                } else if (d + wt == dis[node]) {
                    ways[node] = (ways[node] + ways[no]) % mod;
                }
            }
        }
        return ways[n - 1];
    }
}