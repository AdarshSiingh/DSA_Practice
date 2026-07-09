class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {

        int x = s1.length() , y = s2.length();

        int dp[][] = new int[x+1][y+1];
        StringBuilder ans = new StringBuilder();

        for(int i = 1; i<x+1 ; i++)
        for(int j = 1; j<y+1 ; j++)
        if(s1.charAt(i-1) == s2.charAt(j-1))
        dp[i][j] = 1 + dp[i-1][j-1];
        else
        dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);

        int i = x , j = y;

        while(i>0 && j>0)
        {
            if(s1.charAt(i-1) == s2.charAt(j-1))
            {
                ans.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1])
            {
                ans.append(s1.charAt(i-1));
                i--;
            }
            else
            {
               ans.append(s2.charAt(j-1));
                j--; 
            }
        }

        while(i>0) { ans.append(s1.charAt(i-1)); i-- ;}
        while(j>0) { ans.append(s2.charAt(j-1)); j--;}
        

        return ans.reverse().toString();
    

}
}