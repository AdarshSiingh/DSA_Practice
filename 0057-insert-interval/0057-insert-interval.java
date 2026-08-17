class Solution {
    public int[][] insert(int[][] in, int[] neww) {

        int n = in.length , i =0;
        List<int[]> l = new ArrayList<>();

        while(i<n && in[i][1] < neww[0])
        {
            l.add(in[i]);
            i++;
        }

        while(i<n && in[i][0] <= neww[1])
        {
            neww[0] = Math.min(neww[0] , in[i][0]);
            neww[1] = Math.max(neww[1] ,in[i][1]);
            i++;
        }
        l.add(neww);

        while(i<n)
        l.add(in[i++]);

        return l.toArray(new int[l.size()][]);
        
    }
}