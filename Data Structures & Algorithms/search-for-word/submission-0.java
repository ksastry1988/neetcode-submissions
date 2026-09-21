class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for(int i = 0; i< row; i++){
            for(int j =0; j<col; j++){
                if(backtracking(i, j, board, word, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean backtracking(int row, int col, char[][] board, String word, int index){
        if(word.length() == index) return true;

        if(row < 0 || col < 0 
            || row >= board.length || col >= board[0].length
                || board[row][col] != word.charAt(index)){
                return false;
            }

        char temp = board[row][col] ;
        board[row][col] = '*';

        int[][] offsets = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 

        boolean result = false;

        for(int[] offset: offsets){
            int offsetRow = row+offset[0];
            int offsetCol = col+offset[1];
            result = backtracking(offsetRow, offsetCol, board, word, index+1);

            if(result) break;

        }
        board[row][col] = temp;

        return result;
    }


}
