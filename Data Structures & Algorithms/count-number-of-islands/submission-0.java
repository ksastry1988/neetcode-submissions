class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        int result = 0;
        for(int i = 0; i< rows; i++){
            for(int j = 0; j< cols; j++){
                if(grid[i][j] == '1'){
                    result++;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }
        return result; 
    }

    public void dfs(char[][] grid, int row, int col, int rows, int cols){
        grid[row][col] = '0';

        if(row + 1 < rows && grid[row+1][col] == '1'){
            dfs(grid, row+1, col, rows, cols);
        }
        if(row - 1 >= 0 && grid[row-1][col] == '1'){
            dfs(grid, row-1, col, rows, cols);
        }
        if(col + 1 < cols && grid[row][col+1] == '1'){
            dfs(grid, row, col+1, rows, cols);
        }
        if(col - 1 >= 0 && grid[row][col-1] == '1'){
            dfs(grid, row, col-1, rows, cols);
        }
    }
}
