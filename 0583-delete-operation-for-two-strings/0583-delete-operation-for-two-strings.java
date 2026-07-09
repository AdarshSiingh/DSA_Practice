class Solution {
    public int minDistance(String w1, String w2) {
        int x = w1.length() , y = w2.length();

        Integer dp[][] = new Integer[x][y];

        int ans = longest(x-1,y-1,w1,w2,dp);

        return((x-ans)+(y-ans));
        
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
