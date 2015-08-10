public class Solution {
    
    // DP O(N^4) 
    // reference: http://www.cnblogs.com/yuzhangcmu/p/4189152.html
    // http://blog.csdn.net/linhuanmars/article/details/24506703
    public boolean isScramble(String s1, String s2) {
       if(s1==null || s2==null) return false;
       int length = s1.length();
       
       boolean [][][] cache = new boolean[length][length][length+1];
       
       for(int len = 1; len<=length; len++){
           for(int start1 = 0; start1 <= length-len; start1++){
               for(int start2 = 0; start2 <= length-len; start2++){
                   if(len==1){
                       cache[start1][start2][len] = s1.charAt(start1) ==  s2.charAt(start2);
                       continue;
                   }
                   cache[start1][start2][len] = false;
                   for(int k = 1; k<len; k++){
                       if(cache[start1][start2][k] && cache[start1+k][start2+k][len-k] 
                       || cache[start1][start2+len-k][k] && cache[start1+k][start2][len-k]){
                           cache[start1][start2][len] = true;
                           break;
                       }
                   }
               }
           }
       }
       return cache[0][0][length];
    }

    // recursion + memory
    int [][][] cache;
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length() || !sameLetter(s1, s2, 0, 0, s1.length())) return false;
        int len = s1.length();
        cache = new int[len][len][len];
        
        for (int i = 0; i < len; i++) {
             for (int j = 0; j < len; j++) {
                 for (int k = 0; k < len; k++) {
                     cache[i][j][k] = 0;
                 }
             }
         }
        return isScrambleHelper(s1, s2, 0, 0, len);
    }
    
    public boolean isScrambleHelper(String s1, String s2, int start1, int start2, int len) {
        if(cache[start1][start2][len-1] !=0 ) return cache[start1][start2][len-1] == 1? true:false;
        
        if(!sameLetter(s1, s2, start1, start2, len)) {
            cache[start1][start2][len-1] = -1;
            return false;
        }
        if(s1.substring(start1, start1+len).equals(s2.substring(start2, start2+len))) {
            cache[start1][start2][len-1] = 1;
            return true;
        }
        
        int res = -1;
        for(int i = 1; i<len; i++){
            if( isScrambleHelper(s1, s2, start1, start2, i) && isScrambleHelper(s1, s2, start1+i, start2+i, len-i)) {
                res = 1;
                break;
            }
            
            if( isScrambleHelper(s1, s2, start1, start2+len-i, i) && isScrambleHelper(s1, s2, start1+i, start2, len-i)) {
                res = 1;
                break;
            }
        }
        cache[start1][start2][len-1] = res;
        return res == 1? true:false;
    }
    
    private boolean sameLetter(String s1, String s2, int start1, int start2, int len){
        char[] s1_charArrays = s1.substring(start1, start1+len).toCharArray();
        char[] s2_charArrays = s2.substring(start2, start2+len).toCharArray(); 
        Arrays.sort(s1_charArrays);
        Arrays.sort(s2_charArrays);
        
        String s1_sorted = new String(s1_charArrays);
        String s2_sorted = new String(s2_charArrays);
        return s1_sorted.equals(s2_sorted);
    }

    // recursion + prune 
    // reference: http://www.cnblogs.com/yuzhangcmu/p/4189152.html
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length() || !sameLetter(s1, s2)) return false;
        if(s1.equals(s2)) return true;
        
        for(int i = 1; i<s1.length(); i++){
            String subStr1 = s1.substring(0, i);
            String subStr2 = s2.substring(0, i);
            
            String subStr1_2 = s1.substring(i);
            String subStr2_2 = s2.substring(i);
            
            if( isScramble(subStr1, subStr2) && isScramble(subStr1_2, subStr2_2)) return true;
            
            subStr2 = s2.substring(s1.length()-i);
            subStr2_2 = s2.substring(0, s1.length()-i);
            
            if( isScramble(subStr1, subStr2) && isScramble(subStr1_2, subStr2_2)) return true;
        }
        return false;
    }
    
    private boolean sameLetter(String s1, String s2){
        char[] s1_charArrays = s1.toCharArray();
        char[] s2_charArrays = s2.toCharArray(); 
        Arrays.sort(s1_charArrays);
        Arrays.sort(s2_charArrays);
        
        String s1_sorted = new String(s1_charArrays);
        String s2_sorted = new String(s2_charArrays);
        return s1_sorted.equals(s2_sorted);
    }
}
