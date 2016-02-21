public class WordDictionary {
    
    TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        char[] chs = word.toCharArray();
        TrieNode node = root;
        for(int i = 0; i<chs.length; i++){
            char ch = chs[i];
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
        return helper(word, 0, root);
    }
    
    private boolean helper(String word, int i, TrieNode node){
        char [] chs = word.toCharArray();
        for(; i<chs.length; i++){
            char ch = chs[i];
            if(ch!='.'){
                if(node.children[ch-'a']==null){
                    return false;
                }else{
                    node = node.children[ch-'a'];
                }
            }else{
                for(int j = 0; j<26; j++){
                    if(node.children[j]!=null && helper(word, i+1, node.children[j])){
                        return true;
                    }
                }
                return false;
            }
        }
        if(node.isWord) {
            return true;
        }else{
            return false;
        }
    }
    
    private class TrieNode{
        TrieNode [] children;
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
