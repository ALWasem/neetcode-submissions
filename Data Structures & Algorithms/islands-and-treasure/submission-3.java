class Solution {
    public void islandsAndTreasure(int[][] grid) {

        Queue<int[]> seen = new LinkedList<>();

        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 0)
                    seen.offer(new int[] {r, c});
            }
        }

        int dist = 1;

        while(!seen.isEmpty()){

            int size = seen.size();

            for(int i = 0; i < size; i++){

                int[] cord = seen.poll();
                int r = cord[0];
                int c = cord[1];

                dfs(r + 1, c, dist, grid, seen);
                dfs(r - 1, c, dist, grid, seen);
                dfs(r, c + 1, dist, grid, seen);
                dfs(r, c - 1, dist, grid, seen);

            }

            dist++;

        }
        
    }

    public void dfs(int r, int c, int dist, int[][] grid, Queue<int[]> seen){

        if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 2147483647){
            grid[r][c] = dist;
            seen.offer(new int[] {r, c});
        }

    }
}
