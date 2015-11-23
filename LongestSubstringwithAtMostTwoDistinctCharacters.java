public class Solution {
    // Refactor a little
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        int global = 0;
        int l = 0, r = 0;
        
        while(r<s.length()){
            char c = s.charAt(r);
            
            if(hm.containsKey(c)){
                hm.put(c, hm.get(c)+1);
            }else{
                while(hm.size()==2){ // need to move l towards right
                   char toRemove = s.charAt(l++);
                   if(hm.get(toRemove)==1) hm.remove(toRemove);
                   else hm.put(toRemove, hm.get(toRemove)-1);
                }
                hm.put(c, 1);
            }
            global = Math.max(global, r-l+1);
            r++;
        }
        return global;
    }
    
    public int lengthOfLongestSubstringTwoDistinctMine(String s) {
        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        int global = 0;
        int l = 0, r = 0;
        
        while(r<s.length()){
            char c = s.charAt(r);
            while(hm.size()==2 && !hm.containsKey(c)){ // need to move l towards right
                char toRemove = s.charAt(l++);
                if(hm.get(toRemove)==1) hm.remove(toRemove);
                else hm.put(toRemove, hm.get(toRemove)-1);
            }
            
            if(hm.containsKey(c)){
                hm.put(c, hm.get(c)+1);
            }else{
                hm.put(c, 1);
            }
            global = Math.max(global, r-l+1);
            r++;
        }
        return global;
    }
}
