class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[n*n + 1];

        int steps = 0;
        q.offer(1);
        vis[1] = true;

        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                int curr = q.poll();
                if(curr == n * n) return steps;

                for(int dice=1; dice<=6; dice++){
                    int next = curr + dice;
                    if(next > n * n) break;

                    int bottomRow = (next - 1) / n;
                    int row = n - 1 - bottomRow;
                    int col = (next - 1) % n;
                    if(bottomRow % 2 == 1) col = n - 1 - col;

                    if(board[row][col] != -1) next = board[row][col];
                    if(!vis[next]){
                        q.offer(next);
                        vis[next] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}