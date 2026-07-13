class Solution {
    public int maxProfit(int k, int[] p) {
        int n = p.length;
        Integer dp[][][] = new Integer[n][2][k+1];

        return profit(0,1,n,p,dp,k);
    }
    int profit(int i , int buy , int n , int[] p , Integer[][][] dp, int cap)
    {
        if(cap == 0) return 0;
        if(i == n) return 0;

        if(dp[i][buy][cap] != null) return dp[i][buy][cap]; 

        int profit = 0;

        if(buy == 1)
        {
            profit = Math.max( 0 + profit(i+1,1,n,p,dp,cap) , -p[i] + profit(i+1,0,n,p,dp,cap) );

        }
        else
        profit = Math.max( p[i] + profit(i+1,1,n,p,dp,cap-1) , 0 + profit(i+1,0,n,p,dp,cap));

        return dp[i][buy][cap] = profit;
    }
}