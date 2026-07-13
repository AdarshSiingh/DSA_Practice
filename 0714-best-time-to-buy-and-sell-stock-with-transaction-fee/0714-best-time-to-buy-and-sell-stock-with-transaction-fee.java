class Solution {
    public int maxProfit(int[] p, int fee) {
        int n = p.length;
        Integer dp[][] = new Integer[n][2];

        return profit(0,1,n,p,dp,fee);
    }
    int profit(int i , int buy , int n , int[] p , Integer[][] dp, int f)
    {
        if(i == n) return 0;

        if(dp[i][buy] != null) return dp[i][buy]; 

        int profit = 0;

        if(buy == 1)
        {
            profit = Math.max( 0 + profit(i+1,1,n,p,dp,f) , -p[i] + profit(i+1,0,n,p,dp,f) );

        }
        else
        profit = Math.max( p[i]-f + profit(i+1,1,n,p,dp,f) , 0 + profit(i+1,0,n,p,dp,f));

        return dp[i][buy] = profit;
    }
}