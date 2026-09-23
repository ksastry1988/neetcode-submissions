class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root; 
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(curr.children[index] == null ){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int index, TrieNode curr){
        if(curr == null) return false;
        if(word.length() == index) return curr.isWord;

        char ch = word.charAt(index);

        if(ch == '.'){
            for(TrieNode child: curr.children){
                if(child != null && dfs(word, index+1, child)){
                    return true;
                }
            }
            return false;
        }

        int childIndex = ch - 'a';
        return dfs(word, index+1, curr.children[childIndex]);
    }
}
