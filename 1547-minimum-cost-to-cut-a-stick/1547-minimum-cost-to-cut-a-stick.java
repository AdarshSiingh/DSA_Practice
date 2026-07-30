class Solution {
    public int minCost(int n, int[] cuts) {

        List<Integer> l = new ArrayList<>();
        l.add(0);

        for(int i : cuts) l.add(i);

        l.add(n);

        Collections.sort(l);

        int c = cuts.length;

        Integer[][] dp = new Integer[c+1][c+1];

        return f(1,c,l,dp);
    }
    int f(int i , int j , List<Integer> l , Integer[][] dp)
    {
        if(i>j) return 0;

        if(dp[i][j] != null) return dp[i][j];

        int min = Integer.MAX_VALUE;

        for(int k =i ;k<=j;k++)
        {
            int cost = l.get(j+1) - l.get(i-1) + f(i,k-1,l,dp) + f(k+1,j,l,dp);

            min = Math.min(min,cost);

        }
        return dp[i][j] = min;
    }
}