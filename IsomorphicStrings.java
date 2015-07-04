public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        
        int [] s_chars = new int[128];
        int [] t_chars = new int[128];
        
        for(int i = 0; i<s.length(); i++){
            char ch_s = s.charAt(i);
            char ch_t = t.charAt(i);
            
            if(s_chars[ch_s] != t_chars[ch_t]){
                return false;
            }else{
                s_chars[ch_s] = i+1; // int array were initialized to 0. so +1 to avoid confusion.
                t_chars[ch_t] = i+1;
            }
        }
        return true;
    }
    
    public boolean isIsomorphic(String s, String t) {
        
        if(s.length() != t.length()) return false;
        
        Map<Character, Character> matching = new HashMap<Character, Character>();
        HashSet<Character> t_occurence = new HashSet<Character>();
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            char ch_t = t.charAt(i);
            
            if(matching.containsKey(ch)){
                if(matching.get(ch) != ch_t){
                    return false;
                }
            }else{
                if(!t_occurence.add(ch_t)){
                    return false;
                }
                matching.put(ch, ch_t);
            }
        }
        return true;
    }
}
