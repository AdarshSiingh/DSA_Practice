class Solution {
     public int minInsertions(String s) {

        Integer[][] dp = new Integer[s.length()][s.length()];
        StringBuilder s2 = new StringBuilder(s);

        String s22 = s2.reverse().toString();

        return ( s.length() - longest(s.length()-1, s.length()-1 , s , s22 , dp));

        
    }
    int longest(int i , int j ,String a , String b, Integer[][] dp)
    {
        if(i<0 || j<0) return 0;

        if(dp[i][j] != null) return dp[i][j];

        if(a.charAt(i) == b.charAt(j))
        return dp[i][j] = 1 + longest(i-1,j-1,a,b,dp);

        return dp[i][j] = Math.max(longest(i-1,j,a,b,dp) , longest(i,j-1,a,b,dp));
    }
}