class Solution {
    public int change(int amt, int[] coins) {
        int x = coins.length;
        
        Integer dp[][] = new Integer[x][amt+1];

        return count(x-1,amt,coins,dp);
    }
    int count(int i , int t , int a[] , Integer dp[][])
    {
        if(i == 0)
        {
            if(t%a[0] == 0) return 1;
            return 0;
        }

        if(dp[i][t] != null) return dp[i][t];

        int n = count(i-1,t,a,dp);

        int p = t>=a[i] ? count(i,t-a[i],a,dp) : 0;

        return dp[i][t] = n+p;
    }
}