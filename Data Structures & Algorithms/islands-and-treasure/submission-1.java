class Solution {
    private static final int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                      queue.offer(new int[]{r, c});
                }
            }
        }
    
       while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int[][] directions = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
            };
            for(int[] dir: directions){
                int nr = dir[0] + r;
                int nc = dir[1]+ c;
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                    continue;
                }
                if (grid[nr][nc] != INF) {
                    continue;
                }
                grid[nr][nc] = grid[r][c] + 1;
                queue.offer(new int[]{nr, nc});

        }
    }
 }
}