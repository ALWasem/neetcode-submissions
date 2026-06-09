class Solution {

    Set<List<Integer>> visit = new HashSet<>();

    int ROW;
    int COL;

    public int countPaths(int[][] grid) {

        this.ROW = grid.length;
        this.COL = grid[0].length;

        return dfs(0, 0, grid);

    }

    public int dfs(int r, int c, int[][] grid){

        List<Integer> set = new ArrayList<>();
        set.add(r);
        set.add(c);

        int count = 0;

        if(Math.min(r, c) < 0 || r == ROW || c == COL 
            || grid[r][c] == 1 || visit.contains(set)){

            return 0;
        }
        else if(r == ROW - 1 && c == COL - 1)
            return 1;

        visit.add(set);

        count += dfs(r + 1, c, grid);
        count += dfs(r, c + 1, grid);
        count += dfs(r - 1, c, grid);
        count += dfs(r, c - 1, grid);

        visit.remove(set);

        return count;

    }


}
