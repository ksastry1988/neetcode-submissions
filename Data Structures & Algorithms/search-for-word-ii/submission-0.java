class TrieNode{
    TrieNode[] children = new TrieNode[26];
    String word;
}
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        if(board == null || board.length == 0 || 
            board[0].length == 0 || words.length == 0 || words == null) return result; 

        TrieNode root = buildTrie(words);

        for(int i = 0; i< board.length; i++){
            for(int j = 0; j< board[0].length; j++){
                dfs(board, root, i, j, result);
            }
        }   
        return result; 
    }

    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word: words){
            TrieNode curr = root;
            for(char ch : word.toCharArray()){
                int index = ch - 'a';
                if(curr.children[index] == null){
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index++];
            }
            curr.word = word;
        }
        return root; 
    }

    public void dfs(char[][] board, 
        TrieNode parent, int row, int col, 
        List<String> result){

            if(row < 0 || col < 0 || row >= board.length || 
                col >= board[0].length) return;

            char ch = board[row][col];
            if(ch == '*') return;

            int index = ch - 'a';
            TrieNode curr = parent.children[index];

            // Word not found
            if(curr == null) return; 

            // Complete word is found
            if(curr.word != null){
                result.add(curr.word);

                curr.word = null;
            }

            board[row][col] = '*';

            int[][] offsets = {{1,0},{-1,0},{0,1},{0,-1}};
            for(int[] offset: offsets){
                dfs(board, curr, row+offset[0], col+offset[1], result);
            }

            board[row][col] = ch;
        }
}
