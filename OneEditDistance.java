public class Solution {
    
    // https://leetcode.com/discuss/54087/easy-understood-java-solution
    public boolean isOneEditDistance(String s, String t) {
        if(s==null||t==null) return false;
        int diff = Math.abs(s.length()-t.length());
        if(diff>1) return false;
        if(diff==0) return isOneModify(s, t);
        return isDel(s, t);
    }
    
    private boolean isOneModify(String s, String t){
        int diff = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)!=t.charAt(i)){
                diff++;
                if(diff>1) return false;
            }
        }
        return diff==1;
    }
    
    private boolean isDel(String s, String t){
        String toDel = s.length()>=t.length()?s:t;
        String shorter = s.length()>=t.length()?t:s;
        
        for(int i = 0; i<shorter.length(); i++){
            if(toDel.charAt(i)!=shorter.charAt(i)){
                return toDel.substring(i+1).equals(shorter.substring(i));
            }
        }
        return true;
    }
}
