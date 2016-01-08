public class Solution {
    public boolean wordPattern(String pattern, String str) {
        Set<String> set = new HashSet<String>();
        Map<Character, String> hm = new HashMap<Character, String>();
        
        String[] strs = str.split(" ");
        if(strs.length!=pattern.length()) return false;
        
        for(int i = 0; i<pattern.length(); i++){
            char ch = pattern.charAt(i);
            
            if(hm.containsKey(ch)){
                if(!hm.get(ch).equals(strs[i])) return false;
            }else{
                if(!set.add(strs[i])) return false;
                hm.put(ch, strs[i]);
            }
        }
        return true;
    }
}
