class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length , tot = 0;

        for(int i: nums) tot += i;
        if(tot%2 != 0) return false;
        int target = tot/2;

        Boolean dp[][] = new Boolean[n][target+1];

        return sum(n-1,target,nums,dp);
        
    }
    boolean sum(int i , int t , int n[] , Boolean dp[][])
    {
        if(t == 0) return true;
        if(i == 0) return (n[0] == t);

        if(dp[i][t] != null) return dp[i][t];

        boolean np = sum(i-1,t,n,dp);
        boolean p = t >= n[i] ? sum(i-1,t-n[i],n,dp) : false;

       dp[i][t] = np || p;

       return dp[i][t];
    }
}