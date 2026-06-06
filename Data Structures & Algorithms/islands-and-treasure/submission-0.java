class Solution {
    private static final int INF = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    dfs(grid, r, c, 0);
                }
            }
        }
    }

    private void dfs(int[][] grid, int r, int c, int dist) {
        int rows = grid.length;
        int cols = grid[0].length;

        // boundary check
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return;
        }

        // water
        if (grid[r][c] == -1) {
            return;
        }

        // already found a shorter path
        if (dist > grid[r][c]) {
            return;
        }

        grid[r][c] = dist;

        dfs(grid, r + 1, c, dist + 1);
        dfs(grid, r - 1, c, dist + 1);
        dfs(grid, r, c + 1, dist + 1);
        dfs(grid, r, c - 1, dist + 1);
    }
}