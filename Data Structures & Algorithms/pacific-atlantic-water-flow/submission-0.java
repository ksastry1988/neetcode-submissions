class Solution {
    private final int[][] offsets = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights){
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

       
        for(int c = 0 ; c < cols; c++){
            dfs(heights, pac, 0, c);
            dfs(heights, atl, rows - 1, c);
        }
        for(int r = 0; r < rows; r++){
            dfs(heights, pac, r, 0);
            dfs(heights, atl, r, cols - 1);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(pac[i][j] && atl[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
    return res;
    }

    public void dfs(int[][] heights, boolean[][] visited, int row, int col){
        if(visited[row][col]) return;

        visited[row][col] = true;

        for(int[] offset: offsets){
            int newRow = row + offset[0];
            int newCol = col + offset[1];
            if(newRow >=0 && newCol >= 0 &&
                newRow < heights.length && newCol < heights[0].length &&
                    heights[newRow][newCol] >= heights[row][col]) {
                dfs(heights, visited, newRow, newCol);
            }
        }
    }
}
