class Solution {
    public int minDistance(String s, String t) {
        int n = s.length() , m = t.length();
        long[][] dp = new long[n+1][m+1];
         
       
        for(int i = 0;i<n+1;i++) dp[i][0] = i;
        for(int i = 0;i<m+1;i++) dp[0][i] = i;

        for(int i = 1;i<n+1;i++)
        for(int j = 1;j<m+1;j++)
        {
            if(s.charAt(i-1) == t.charAt(j-1))
            dp[i][j] = dp[i-1][j-1] ;
            else
            dp[i][j] = Math.min( 1 + dp[i-1][j] , Math.min(1 + dp[i-1][j-1] , 1 + dp[i][j-1]));
        }

        return(int)dp[n][m];
        
    }
}