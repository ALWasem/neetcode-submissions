class Solution {

    int ROW;
    int COL;

    public int maxAreaOfIsland(int[][] grid) {

        int max = 0;

        this.ROW = grid.length;
        this.COL = grid[0].length;

        for(int r = 0; r < ROW; r++){
            for(int c = 0; c < COL; c++){
                if(grid[r][c] == 1){
                    max = Math.max(max, dfs(r, c, grid));
                }
            }
        }

        return max;
        
    }

    public int dfs(int r, int c, int[][] grid){

        if(Math.min(r, c) < 0 || r == ROW || c == COL || grid[r][c] == 0){
            return 0 ;
        }
        
        grid[r][c] = 0;

        return 1
            + dfs(r + 1, c, grid)
            + dfs(r - 1, c, grid)
            + dfs(r, c + 1, grid)
            + dfs(r, c - 1, grid);

        
    }
}
