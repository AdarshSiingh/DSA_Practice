class Solution {
    public int longestStrChain(String[] w) {

        int n = w.length;

        Integer[][] dp = new Integer[n][n+1];

        Arrays.sort(w , (a,b) -> a.length() - b.length());

        return match(0,-1,w,dp);
        
    }

    int match(int i , int p , String[] w , Integer[][] dp)
    {
        if(i == w.length) return 0;

        if(dp[i][p+1] != null) return dp[i][p+1];

        int np = 0 + match(i+1,p,w,dp);

        int pick =0;
        if(p==-1 || diff(w[p],w[i]))
        pick = 1 + match(i+1,i,w,dp);

       return dp[i][p+1] = Math.max(np,pick);
    }

    boolean diff(String a , String b)
    {
        int x = a.length() , y = b.length();

        if(y != x+1) return false;

        int i =0,j=0;

        while(i<x && j<y)
        {
            if(a.charAt(i) == b.charAt(j))
            {
                i++;
                j++;
            }
            else
            j++;
        }

        return i == x;
    }
}