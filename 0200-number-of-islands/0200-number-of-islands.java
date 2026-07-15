class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        int dirs[][] = {{1,0},{0,-1},{-1,0},{0,1}};
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == '1'){
                    count++;
                    grid[i][j] = '0';
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i,j});
                    while(!q.isEmpty()){
                        int curr[] = q.poll();
                        for(int d[] : dirs){
                            int nr = curr[0] + d[0];
                            int nc = curr[1] + d[1];
                            if(nr >= 0 && nc >= 0 && nr < row && nc < col && grid[nr][nc] == '1'){
                                grid[nr][nc] = '0';
                                q.offer(new int[]{nr,nc});
                            }
                        }
                    }   
                }
            }
        }
        return count;
    }
}