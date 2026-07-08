class Solution {
    public int coinChange(int[] coins, int amt) {

        Integer dp[][] = new Integer[coins.length][amt+1];

       int ans =  sum(coins.length-1,amt,coins,dp);

       return ans >= Integer.MAX_VALUE/2 ? -1 : ans;
        
    }
    int sum(int i , int t , int[] c , Integer dp[][] )
    {
        if(i == 0)
        {
            if(t%c[i] == 0) return t/c[i];
            return Integer.MAX_VALUE/2;
        }


        if(dp[i][t] != null) return dp[i][t];

        int np = sum(i-1,t,c,dp);
        int p =  (t >= c[i]) ? 1 + sum(i,t-c[i],c,dp) : Integer.MAX_VALUE/2;

        return dp[i][t] = Math.min(np , p);
    }

}