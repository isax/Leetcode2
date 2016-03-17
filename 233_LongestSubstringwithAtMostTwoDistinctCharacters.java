public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int l = 0, r = 0;
        int len = s.length();
        
        int max = 0;
        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        while(r<len){
            char ch = s.charAt(r);
            if(hm.containsKey(ch)){
                hm.put(ch, hm.get(ch)+1);
            }else{
                hm.put(ch, 1);
            }
            
            while(hm.size()>2){
                char chL = s.charAt(l++);
                if(hm.get(chL)==1) hm.remove(chL);
                else hm.put(chL, hm.get(chL)-1);
            }
            max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
}
