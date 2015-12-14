class TrieNode {
    // https://leetcode.com/discuss/46959/ac-java-solution-simple-using-single-array
    
    
    // Initialize your data structure here.
    boolean isEndOfAWord;
    TrieNode [] children;
    public TrieNode() {
        this.isEndOfAWord = false;
        children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(cur.children[ch-'a']==null){
               cur.children[ch-'a'] = new TrieNode();
            }
            cur = cur.children[ch-'a'];
        }
        cur.isEndOfAWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(cur.children[ch-'a']==null){
               return false;
            }
            cur = cur.children[ch-'a'];
        }
        return cur.isEndOfAWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(cur.children[ch-'a']==null){
               return false;
            }
            cur = cur.children[ch-'a'];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
