class Solution {
    public boolean isMatch(String s, String p) {

        int x = s.length(), y = p.length();
        Boolean[][] dp = new Boolean[x][y];

        return match(x - 1, y - 1, s, p, dp);
    }

    boolean match(int i, int j, String s, String t, Boolean[][] dp) {

        if (i < 0 && j < 0) return true;

        if (i >= 0 && j < 0) return false;

        if (i < 0 && j >= 0) {
            for (int jj = 0; jj <= j; jj++)
                if (t.charAt(jj) != '*') return false;
            return true;
        }

        if (dp[i][j] != null) return dp[i][j];

        if (s.charAt(i) == t.charAt(j) || t.charAt(j) == '?')
            return dp[i][j] = match(i - 1, j - 1, s, t, dp);

        if (t.charAt(j) == '*')
            return dp[i][j] = match(i - 1, j, s, t, dp)
                           || match(i, j - 1, s, t, dp);

        return dp[i][j] = false;
    }
}