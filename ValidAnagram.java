public class Solution {
    public boolean isAnagram2(String s, String t) {
        char[] charArrayS = s.toCharArray();
        Arrays.sort(charArrayS);
        
        char[] charArrayT = t.toCharArray();
        Arrays.sort(charArrayT);
        
        return Arrays.equals(charArrayS, charArrayT);
    }
    
    public boolean isAnagram(String s, String t) {
        if(s==null || t==null || s.length()!=t.length()) return false;
        int[] count = new int[26];
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            count[ch-'a']++; // - 'a'
        }
        
        for(int i = 0; i<t.length(); i++){
            char ch = t.charAt(i);
            
            if(count[ch-'a']>0){
                count[ch-'a']--;
            }else{
                return false;
            }
        }
        return true;
    }
}
