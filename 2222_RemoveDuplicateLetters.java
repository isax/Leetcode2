public class Solution {
    public String removeDuplicateLetters(String s) {
        LinkedList<Character> list = new LinkedList<Character>();
        int[] lastOccur = new int[26];
        boolean[] inRes = new boolean[26];
        
        char []chs = s.toCharArray();
        for(int i = chs.length-1; i>=0; i--){
            char ch = chs[i];
            if(lastOccur[ch-'a']==0) lastOccur[ch-'a'] = i;
        }
        
        for(int i = 0; i<chs.length; i++){
            char ch = chs[i];
            if(inRes[ch-'a']) continue;
            while(!list.isEmpty() && list.getLast()>=ch && lastOccur[list.getLast()-'a']>=i){
                char remove = list.removeLast();
                inRes[remove-'a'] = false;
            }
            list.addLast(ch);
            inRes[ch-'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(char i : list){
           sb.append(i); 
        }
        return sb.toString();
    }
}
