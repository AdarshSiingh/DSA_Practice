class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        Integer dp[][] = new Integer[triangle.size()][triangle.size()];
        return min(0,0,triangle,dp);        
    }
    int min(int i , int j , List<List<Integer>> t , Integer[][] dp)
    {
        if(i==t.size()-1)
        return t.get(i).get(j);

        if(dp[i][j] != null) return dp[i][j];

        int x = t.get(i).get(j) + min(i+1,j,t,dp);
        int y = t.get(i).get(j) + min(i+1,j+1,t,dp);

        dp[i][j] = Math.min(x,y);

        return dp[i][j];

    }
}