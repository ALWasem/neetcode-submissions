class Solution {
    public void islandsAndTreasure(int[][] grid) {

        Queue<int[]> queue = new ArrayDeque<>();
        
        int r = grid.length;
        int c = grid[0].length;

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 0)
                    queue.add(new int[] {i, j});
            }
        }

        int dist = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cord = queue.poll();
                int row = cord[0];
                int col = cord[1];

                grid[row][col] = dist;
                
                dfs(row + 1, col, grid, queue, dist);
                dfs(row, col + 1, grid, queue, dist);
                dfs(row - 1, col, grid, queue, dist);
                dfs(row, col - 1, grid, queue, dist);
            }
            dist++;
        }
    }

    public void dfs(int r, int c, int[][] grid, Queue<int[]> queue, int dist){

        int rl = grid.length;
        int cl = grid[0].length;

        if(r >= rl || c >= cl || r < 0 || c < 0 || grid[r][c] != Integer.MAX_VALUE)
            return;

        queue.add(new int[] {r, c});

        grid[r][c] = dist;


    }




}
