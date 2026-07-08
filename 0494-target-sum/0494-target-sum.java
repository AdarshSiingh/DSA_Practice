class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int x = 0;
        for(int i : nums) x+=i;
        Integer dp[][] = new Integer[nums.length][2*x+1];
        return count(nums.length-1,target,0,nums,dp,x);        
    }

    int count(int i , int t ,int s , int n[] , Integer dp[][], int x)
    {
        if(i == 0)
        { int ans = 0;
        if(s + n[0] == t ) ans++;
        if(s-n[0]==t) ans++;
        return ans;
        }

        if(dp[i][s+x] != null) return dp[i][s+x];

        int m = count(i-1,t,s-n[i],n,dp,x);
        int p = count(i-1,t,s + n[i],n,dp,x);

        return dp[i][s+x] = m+p;
    }
}