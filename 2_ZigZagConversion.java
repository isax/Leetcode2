public class Solution {
    public String convert(String s, int numRows) {
        if(numRows<=1) return s;
        
        int len = numRows*2 - 2;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<numRows; i++){
            int offset = i;
            int mid = len-i;
            for(int j = 0; j<s.length(); j+=len){
                if(j+offset<s.length()) {
                    sb.append(s.charAt(j+offset));
                }
                if(offset!=0 && offset!=mid && j+mid<s.length()){
                    sb.append(s.charAt(j+mid));
                }
            }
        }
        return sb.toString();
    }
}
