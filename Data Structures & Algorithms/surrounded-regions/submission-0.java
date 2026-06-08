class Solution {
    
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if ((r == 0 || r == rows-1 || c == 0 || c == cols-1) 
                    && board[r][c] == 'O') {
                    dfs(r, c, board);
                }
            }
        }
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O')      board[r][c] = 'X'; 
                else if (board[r][c] == 'S') board[r][c] = 'O'; 
            }
        }
    }
    
    public void dfs(int r, int c, char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        if (r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != 'O')
            return;
        
        board[r][c] = 'S'; 
        dfs(r + 1, c, board);
        dfs(r - 1, c, board);
        dfs(r, c + 1, board);
        dfs(r, c - 1, board);
    }
}

