class Solution {
    public boolean canFinish(int cr, int[][] pre) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i< cr ; i++ )
        adj.add(new ArrayList<>());

        int in[] = new int[cr]; int c = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int p[] : pre)
        {
            adj.get(p[1]).add(p[0]);
            in[p[0]]++;
        }

        for (int i = 0; i < cr; i++) {
        if (in[i] == 0)
        q.add(i);
        }

        while(!q.isEmpty())
        {
            int n = q.remove();
            c++;

            for(int i : adj.get(n))
            {
                in[i]--;

                if(in[i]==0)
                q.add(i);
            }
        }

        return c==cr;

        
    }
}