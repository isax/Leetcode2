public class Solution {
    private class Trie{
        TrieNode root;
        Trie(){
            root = new TrieNode();
        }
        
        private void build (String word){
            TrieNode node = root;
            for(int i = 0; i<word.length(); i++){
                char c = word.charAt(i);
                if(node.next[c-'a']==null){
                    node.next[c-'a'] = new TrieNode();
                }
                node = node.next[c-'a'];
            }
            node.isWord = true;
        }
    }
    
    private class TrieNode{
        TrieNode [] next;
        boolean isWord;
        
        TrieNode(){
            next = new TrieNode[26];
            isWord = false;
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word: words){
            trie.build(word);
        }
        
        int row = board.length;
        int col = board[0].length;
        List<String> list = new ArrayList<String>();
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                dfs(board, visited, i, j, new StringBuilder(), trie.root, list);
            }
        }
        return list;
    }
    
    
    private void dfs(char[][]board, boolean[][] visited, int i, int j, StringBuilder sb, TrieNode node, List<String> list){
        char ch = board[i][j];
        if(visited[i][j] || node.next[ch-'a']==null) return;
        
        node = node.next[ch-'a'];
        sb.append(ch);
        
        if(node.isWord){
            list.add(sb.toString());
            node.isWord = false; //dedup
        }
        visited[i][j] = true;
        
        if(i>0) dfs(board, visited, i-1, j, sb, node, list);
        if(i<board.length-1) dfs(board, visited, i+1, j, sb, node, list);
        if(j>0) dfs(board, visited, i, j-1, sb, node, list);
        if(j<board[0].length-1) dfs(board, visited, i, j+1, sb, node, list);
        
        sb.setLength(sb.length()-1);
        visited[i][j] = false;
    }
}
