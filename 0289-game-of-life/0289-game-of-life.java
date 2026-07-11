class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        // brute force using extra matrix so store that state and copied it back to the original one
        int dir[][] = {{-1, -1}, {-1, 0}, {0, -1}, {1, 0}, {0, 1}, {1, 1}, {1, -1}, {-1, 1}};
        // int ans[][] = new int[m][n];
        // for(int row[] : ans) Arrays.fill(row, -1);
        // for(int i=0; i<m; i++){
        //     for(int j=0; j<n; j++){
        //         int ones = 0;
        //         for(int d[] : dir){
        //             int nr = i + d[0], nc = j + d[1];
        //             if(nr >= 0 && nc >= 0 && nr < m && nc < n){
        //                 if(board[nr][nc] == 1) ones++;
        //             }
        //         }
        //         int curr = board[i][j];
        //         if(curr == 1 && ones < 2) ans[i][j] = 0;
        //         else if(curr == 1 && (ones == 2 || ones == 3)) ans[i][j] = 1;
        //         else if(curr == 1 && ones > 3) ans[i][j] = 0;
        //         else if(curr == 0 && ones == 3) ans[i][j] = 1;
        //     }
        // }
        // for(int i=0; i<m; i++){
        //     for(int j=0; j<n; j++){
        //         if(ans[i][j] != -1) board[i][j] = ans[i][j];
        //     }
        // }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int lives = count(dir, i, j, board);
                if(board[i][j] == 1){
                    if(lives < 2 || lives > 3) board[i][j] = -1;
                }
                else{
                    if(lives == 3) board[i][j] = 2;
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == -1) board[i][j] = 0;
                else if(board[i][j] == 2) board[i][j] = 1;
            }
        }
    }
    public int count(int dir[][], int i, int j, int board[][]){
        int count = 0;
        for(int d[] : dir){
            int nr = i + d[0];
            int nc = j + d[1];
            if(nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length
                && (board[nr][nc] == 1 || board[nr][nc] == -1)){
                count++;
            }
        }
        return count;
    }
}