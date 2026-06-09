class Solution {

    int ROW;
    int COL;

    public int numIslands(char[][] grid) {

        this.ROW = grid.length;
        this.COL = grid[0].length;

        int count = 0;

        for(int r = 0; r < ROW; r++){
            for(int c = 0; c < COL; c++){
                if(grid[r][c] == '1'){
                    count++;
                    dfs(r, c, grid);
                }
            }
        }

        return count;
        
    }

    public void dfs(int r, int c, char[][] grid){

        if(Math.min(r, c) < 0 || r == ROW || c == COL || grid[r][c] == '0')
            return;

        if(grid[r][c] == '1')
            grid[r][c] = '0';

        dfs(r + 1, c, grid);
        dfs(r - 1, c, grid);
        dfs(r, c + 1, grid);
        dfs(r, c - 1, grid);

    }
}
