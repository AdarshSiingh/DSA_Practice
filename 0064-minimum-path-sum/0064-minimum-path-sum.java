class Solution {
    public int minPathSum(int[][] g) {

        int m = g.length , n = g[0].length;        
        int dp[][] = new int[m][n];

        for(int[] i : dp) Arrays.fill(i,-1);

        return min(m-1,n-1,g,dp);
        
    }
    int min(int m , int n , int[][] g , int dp[][])
    {
        if(m==0 && n==0) return g[0][0];
        if(m<0 || n<0) return Integer.MAX_VALUE/2;

        if(dp[m][n] != -1) return dp[m][n];

        int up = g[m][n] + min(m-1,n,g,dp);
        int left = g[m][n] + min(m,n-1,g,dp);

        dp[m][n] = Math.min(up,left);

        return dp[m][n];
    }
}