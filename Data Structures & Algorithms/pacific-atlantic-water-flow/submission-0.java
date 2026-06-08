class Solution {

    private int[][] dirs = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Pacific borders
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, 0, pacific);
            dfs(heights, r, cols - 1, atlantic);
        }

        // Top and bottom borders
        for (int c = 0; c < cols; c++) {
            dfs(heights, 0, c, pacific);
            dfs(heights, rows - 1, c, atlantic);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights,
                     int r,
                     int c,
                     boolean[][] visited) {

        if (visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nc < 0 ||
                nr >= heights.length ||
                nc >= heights[0].length) {
                continue;
            }

            // Reverse flow condition
            if (heights[nr][nc] >= heights[r][c]) {
                dfs(heights, nr, nc, visited);
            }
        }
    }
}