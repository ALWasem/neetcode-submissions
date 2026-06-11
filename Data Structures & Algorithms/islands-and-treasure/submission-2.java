class Solution {
    public void islandsAndTreasure(int[][] grid) {

        Queue<int[]> seen = new LinkedList<>();

        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 0)
                    seen.add(new int [] {r, c});
            }
        }

        int dist = 1;

        while(!seen.isEmpty()){

            int size = seen.size();
            for(int i = 0; i < size; i++){

                int[] cord = seen.poll();
                int r = cord[0];
                int c = cord[1];

                //grid[r][c] = dist;

                dfs(r + 1, c, grid, seen, dist);
                dfs(r - 1, c, grid, seen, dist);
                dfs(r, c + 1, grid, seen, dist);
                dfs(r, c - 1, grid, seen, dist);
            }

            dist++;
        }
        
    }

    public void dfs(int r, int c, int[][] grid, Queue<int[]> seen, int dist){

        if(r < grid.length && c < grid[0].length && r >= 0 && c >= 0 && grid[r][c] == 2147483647){
            grid[r][c] = dist;
            seen.add(new int[] {r, c});

        }

    }
}
