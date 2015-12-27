public class Solution {
    // https://leetcode.com/discuss/15098/very-simple-dfs-solution
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<String>();
        helper(0, 0, s, new StringBuilder(), list);
        return list;
    }
    
    private void helper(int cur, int segment, String s, StringBuilder sb, List<String>list){
        if(segment==4){
            if(cur==s.length()){
                list.add(sb.toString());
            }
            return;
        }
        
        int len = sb.length();
        if(segment!=0) sb.append(".");
        
        for(int i = 0; i<3 && cur+i<s.length(); i++){
            String subString = s.substring(cur, cur+i+1);
            if(isValid(subString)){
                sb.append(subString);
                helper(cur+i+1, segment+1, s, sb, list);
                sb.setLength(sb.length()-i-1);
            }
        }
        sb.setLength(len);
    }
    
    private boolean isValid(String s){
        if(s.length()>3) return false;
        if(s.charAt(0)=='0' && s.length()>1) return false;
        int i = Integer.parseInt(s);
        if(i>=0 && i<=255) return true;
        else return false;
    }
}
