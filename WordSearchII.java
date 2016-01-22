public class Solution {
    // https://leetcode.com/discuss/77851/java-15ms-easiest-solution-100-00%25
    public List<String> findWords(char[][] board, String[] words) {
        int row = board.length;
        int col = board[0].length;
        
        List<String> res = new ArrayList<String>();
        TrieNode root = buildTrie(words);
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }
    
    private void dfs(char[][]board, int i, int j, TrieNode node, List<String> list){
        char ch = board[i][j];
        if(ch=='#' || node.children[ch-'a']==null) return;
        
        node = node.children[ch-'a'];
        if(node.word!=null){
            list.add(node.word);
            node.word=null; //dedupe
        }
        
        board[i][j] = '#';
        if(i>0) dfs(board, i-1, j, node, list);
        if(j>0) dfs(board, i, j-1, node, list);
        if(i<board.length-1) dfs(board, i+1, j, node, list);
        if(j<board[0].length-1) dfs(board, i, j+1, node, list);
        
        board[i][j] = ch;
    }
    
    private class TrieNode{
        TrieNode[] children;
        String word;
        
        TrieNode(){
            children = new TrieNode[26];
            word = null;
        }
    }
    
    /*
    public List<String> findWords(char[][] board, String[] words) {
        int row = board.length;
        int col = board[0].length;
        
        Set<String> set = new HashSet<String>();
        TrieNode root = buildTrie(words);
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                dfs(board, i, j, root, set, new StringBuilder());
            }
        }
        List<String> res = new ArrayList<String>(set);
        return res;
    }*/
    
    /*
    private void dfs(char[][]board, int i, int j, TrieNode node, Set<String> set, StringBuilder sb){
        char ch = board[i][j];
        if(ch=='#' || node.children[ch-'a']==null) return;
        
        sb.append(ch);
        if(node.children[ch-'a'].isWord){
            String word = sb.toString();
            set.add(word);
        }
        
        node = node.children[ch-'a'];
        board[i][j] = '#';
        if(i>0) dfs(board, i-1, j, node, set, sb);
        if(j>0) dfs(board, i, j-1, node, set, sb);
        if(i<board.length-1) dfs(board, i+1, j, node, set, sb);
        if(j<board[0].length-1) dfs(board, i, j+1, node, set, sb);
        
        board[i][j] = ch;
        sb.setLength(sb.length()-1);
    }*/
    
    private TrieNode buildTrie(String[]words){
        TrieNode root = new TrieNode();
        for(String s : words){
            TrieNode cur = root;
            char[] cs = s.toCharArray();
            for(char ch : cs){
                if(cur.children[ch-'a']==null){
                    cur.children[ch-'a'] = new TrieNode();
                }
                cur = cur.children[ch-'a'];
            }
            cur.word = s;
        }
        return root;
    }
    /*
    private class TrieNode{
        TrieNode[] children;
        boolean isWord;
        
        TrieNode(){
            children = new TrieNode[26];
            isWord = false;
        }
    }*/
}
