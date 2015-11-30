public class Solution {
    
    // https://leetcode.com/discuss/20993/java-code-with-13-lines
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) return "";
        
        String s = strs[0];
        for(int i = 0; i<strs.length; i++){
            while(strs[i].indexOf(s)!=0) {
                s = s.substring(0, s.length()-1);
            }
        }
        return s;
    }
    
    public String longestCommonPrefixMine(String[] strs) {
        char [] cs = "".toCharArray();
        for(int i = 0; i<strs.length; i++){
            if(i==0) {
                cs = strs[i].toCharArray();
                continue;
            }
            
            for(int j = 0; j<cs.length; j++){
                if(strs[i].length()==j || cs[j]!=strs[i].charAt(j)) {
                    cs = Arrays.copyOfRange(cs, 0, j);
                    break;
                }
            }
        }
        return new String(cs);
    }
}
