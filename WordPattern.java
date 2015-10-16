public class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> hm = new HashMap<Character, String>();
        Set<String> set = new HashSet<String>();
        
        String [] strs = str.split(" ");
        if(strs.length!=pattern.length()) return false;
        
        for(int i = 0; i<pattern.length(); i++){
            char ch = pattern.charAt(i);
            
            if(hm.containsKey(ch)){
                if(!hm.get(ch).equals(strs[i])){
                    return false;
                }
            }else{
                if(set.contains(strs[i])) return false;
                
                hm.put(ch, strs[i]);
                set.add(strs[i]);
            }
        }
        return true;
    }
}
