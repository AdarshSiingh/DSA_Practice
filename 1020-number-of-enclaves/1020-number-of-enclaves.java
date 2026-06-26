class Solution {

    void dfs(int[][] grid, int[][] vis, int r, int c) {

        int n = grid.length;
        int m = grid[0].length;

        if (r < 0 || c < 0 || r >= n || c >= m || vis[r][c] == 1 || grid[r][c] == 0)
            return;

        vis[r][c] = 1;

        dfs(grid, vis, r - 1, c);
        dfs(grid, vis, r, c + 1);
        dfs(grid, vis, r + 1, c);
        dfs(grid, vis, r, c - 1);
    }

    public int numEnclaves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];

        // First and last row
        for (int i = 0; i < m; i++) {

            if (grid[0][i] == 1 && vis[0][i] == 0)
                dfs(grid, vis, 0, i);

            if (grid[n - 1][i] == 1 && vis[n - 1][i] == 0)
                dfs(grid, vis, n - 1, i);
        }

        // First and last column
        for (int i = 0; i < n; i++) {

            if (grid[i][0] == 1 && vis[i][0] == 0)
                dfs(grid, vis, i, 0);

            if (grid[i][m - 1] == 1 && vis[i][m - 1] == 0)
                dfs(grid, vis, i, m - 1);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1 && vis[i][j] == 0)
                    count++;
            }
        }

        return count;
    }
}