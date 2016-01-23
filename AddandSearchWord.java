public class WordDictionary {
    TrieNode root = new TrieNode();
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        char[] c = word.toCharArray();
        TrieNode node = root; 
        for(int i = 0; i<c.length; i++){
            char ch = c[i];
            if(node.children[ch-'a']==null){
                node.children[ch-'a'] = new TrieNode();
            }
            node = node.children[ch-'a'];
        }
        node.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    
    private boolean dfs(String word, int cur, TrieNode node){
        if(cur==word.length()){
            return node.isWord;
        }
        
        char ch = word.charAt(cur);
        if(ch=='.'){
            for(TrieNode child : node.children){
                if(child!=null && dfs(word, cur+1, child)){
                    return true;
                }
            }
            return false;
        }else if(node.children[ch-'a']==null){
            return false;
        }else{
            return dfs(word, cur+1, node.children[ch-'a']);
        }
    }
    
    
    private class TrieNode{
        TrieNode[]children;
        boolean isWord;
        
        TrieNode(){
            children = new TrieNode[26];
            isWord = false;
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
