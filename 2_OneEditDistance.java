public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s==null||t==null) return false;
        int diff = s.length()-t.length();
        if(diff>1 || diff<-1) return false;
        
        if(diff==0){
            return isModifiable(s, t);
        }else{
            return diff>0?isDeletableBetter(s, t):isDeletableBetter(t, s);
        }
    }
    
    private boolean isModifiable(String s, String t){
        int count = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)!=t.charAt(i)){
                if(count>1) return false;
                else count++;
            }
        }
        return count==1;
    }
    
    private boolean isDeletable(String s, String t){
        for(int i = 0; i<s.length(); i++){
            String deleted = s.substring(0, i) + s.substring(i+1); 
            if(deleted.equals(t)) return true;
        }
        return false;
    }
    
    private boolean isDeletableBetter(String s, String t){
        for(int i = 0; i<t.length(); i++){
            if(s.charAt(i)!=t.charAt(i)){
                return s.substring(i+1).equals(t.substring(i));
            } 
        }
        return true; // check "","a", "a", "ac"
    }
}
