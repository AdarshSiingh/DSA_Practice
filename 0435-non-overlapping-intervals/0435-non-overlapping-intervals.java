class Solution {
    public int eraseOverlapIntervals(int[][] in) {
        Arrays.sort(in , (a,b) -> a[1]-b[1]);
        int c = 1 , e = in[0][1];

        for(int i = 0 ; i < in.length ;i++)
        {
            if(in[i][0] >= e)
            {
                c++;
                e=in[i][1];
            }
        } 
        return in.length - c;
    }
}