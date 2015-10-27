public class Solution {
    // TODO KMP
    
    // 1) easy to understand but time consuming..
    // https://leetcode.com/discuss/37314/my-easily-understandable-but-time-consuming-c-solution
    
    // 2) based on longest palindrome
    // https://leetcode.com/discuss/55696/using-longest-palindrome
    // there is a clean one here - https://leetcode.com/discuss/61416/my-9-lines-three-pointers-java-solution-with-explanation
    public String shortestPalindrome(String s) {
        if(s==null || s.length()==0) return s;
        
        // find the longest prefix palindrome
        int longest = helper(s);
        String tail = s.substring(longest);
        return new StringBuilder(tail).reverse().toString() + s;
    }
    private int helper(String s){
        int global = 0;
        for(int i = 0; i<s.length(); i++){
            int odd = expand(s, i, i);
            int even = expand(s, i, i+1);
            
            global = Math.max(global, Math.max(odd, even));
        }
        return global;
    }
    private int expand(String str, int s, int e){
        while(s>=0 && e<str.length() && str.charAt(s)==str.charAt(e)){
            s--;
            e++;
        }
        if(s+1!=0) return 0;
        else return e-s-1;
    }
    
    
}
