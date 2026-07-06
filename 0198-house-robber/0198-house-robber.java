class Solution {
    public int rob(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp,-1);
     
        return sum(n-1,dp,nums);
     
        
    }
    int sum(int n , int[] dp,int[] a)
    {
        if(n==0) return a[n];
        if(n<0) return 0;

        if(dp[n]!= -1) return dp[n];

        int p = a[n] + sum(n-2,dp,a);
        int np = 0 + sum(n-1,dp,a);

       dp[n] = Math.max(p,np);

       return dp[n];
    }
}