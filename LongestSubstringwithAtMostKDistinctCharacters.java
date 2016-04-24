public class Solution {
    // https://leetcode.com/discuss/95698/generic-solution-in-java-that-can-be-used-for-unicode
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==0) return 0;
        
        int max = 0;
        int l = 0, r = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        while(r<s.length()){
            char ch = s.charAt(r);
            map.put(ch, r);
            
            while(map.size()>k){
                char toRemove = s.charAt(l);
                if(map.get(toRemove)==l){
                    map.remove(toRemove);
                }
                l++;
            }
            max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
}
