public class Solution {
    // Another neat solution: http://blog.csdn.net/likecool21/article/details/10858799
    // Code Ganker: http://blog.csdn.net/linhuanmars/article/details/19949159
    public int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<Character>();
        
        int l = 0, r = 0;
        int max = 0;
        while(r<s.length()){
            char ch = s.charAt(r);
            if(!set.add(ch)){
                while(l<r && s.charAt(l)!=ch){
                    set.remove(s.charAt(l)); //
                    l++;
                }
                l++;
            }
            max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
    
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        
        int l = 0, r = 0;
        int max = 0;
        while(r<s.length()){
            char ch = s.charAt(r);
            if(!set.add(ch)){
                while(l<r){
                    if(s.charAt(l)==ch) {
                        l++;
                        break;
                    }else{
                        set.remove(s.charAt(l));
                        l++;
                    }
                }
            }
            max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
}
