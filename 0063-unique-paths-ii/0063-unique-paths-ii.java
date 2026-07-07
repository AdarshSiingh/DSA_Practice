class Solution {
    public int uniquePathsWithObstacles(int[][] g) {
        int m = g.length , n = g[0].length;
        if(g[0][0] == 1 || g[m-1][n-1] == 1) return 0;
        
        int dp[][] = new int[m][n];

        for(int[] i : dp) Arrays.fill(i,-1);

        return count(m-1,n-1,dp,g);
        
    }
        int count(int m , int n , int dp[][], int g[][])
    {
        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;
        if(g[m][n] == 1) return 0;

        if(dp[m][n] != -1) return dp[m][n];

        dp[m][n] = count(m-1,n,dp,g) + count(m,n-1,dp,g);

        return dp[m][n];
    }
}