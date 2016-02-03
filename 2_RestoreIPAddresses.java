public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        helper(s, 0, 0, new StringBuilder(), res);
        return res;
    }
    
    private void helper(String s, int i, int part, StringBuilder sb, List<String> list){
        if(part==4){
            if(i==s.length()) list.add(sb.toString());
            return;
        }
        
        int len = sb.length();
        if(len!=0) sb.append(".");
        
        for(int j = i; j<s.length()&& j<i+3; j++){
            if(s.charAt(i)=='0' && j!=i) break;
            
            String str = s.substring(i, j+1);
            if(isValidSegment(str)){
                sb.append(str);
                helper(s, j+1, part+1, sb, list);
                sb.setLength(sb.length()-str.length());
            }
        }
        sb.setLength(len);
    }
    
    private boolean isValidSegment(String s){
        return Integer.parseInt(s)<=255;
    }
}
