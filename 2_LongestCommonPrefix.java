public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        String prefix = strs[0];
        
        for(int i = 1; i<strs.length; i++){
            int j = 0;
            for(; j<strs[i].length() && j<prefix.length(); j++){
                if(strs[i].charAt(j)!=prefix.charAt(j)) break;
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }
}
