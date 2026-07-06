class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
        return nums[0];

        int[] dp = new int[n];
        int[] t1 = new int[n-1], t2 = new int[n-1];  int k = 0,j=0;

        for(int i = 0;i<n;i++)
        {
            if(i!=0) t1[k++] = nums[i];
            if(i!= n-1) t2[j++] = nums[i];
        }
        Arrays.fill(dp,-1);
        int ans1 =  sum(n-2,dp,t1);
        Arrays.fill(dp,-1);
        int ans2 =  sum(n-2,dp,t2);

        return Math.max(ans1,ans2);
     
        
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