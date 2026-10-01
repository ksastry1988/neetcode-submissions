class Solution {
    public int islandPerimeter(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for(int i = 0; i< rows; i++){
            for(int j = 0; j< cols; j++){
                if(grid[i][j] == 1)
                    return dfs(grid, visited, rows, cols, i, j);
            }
        }
        return 0;
    }

    public int dfs(int[][] grid, boolean[][] visited, int rows, int cols, int row, int col){
        if(row < 0 || col < 0 || 
            row >= rows || col >= cols || 
                grid[row][col] == 0){
                    return 1;
                }
        
        if(visited[row][col])return 0;

        visited[row][col] = true;

        return 
            dfs(grid, visited, rows, cols, row + 1, col) + 
            dfs(grid, visited, rows, cols, row - 1, col) + 
            dfs(grid, visited, rows, cols, row, col + 1) + 
            dfs(grid, visited, rows, cols, row, col - 1);
    }
}