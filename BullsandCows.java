public class Solution {
    // https://leetcode.com/discuss/67031/one-pass-java-solution
    public String getHint(String secret, String guess) {
        int a = 0, b = 0;
        
        int[] nums = new int[10];
        
        for(int i = 0; i<secret.length(); i++){
            int chS = secret.charAt(i);
            int chG = guess.charAt(i);
            
            if(chS==chG) a++;
            else {
                if(nums[chS-'0']++<0) b++;
                if(nums[chG-'0']-->0) b++;
            }
        }
        return a+"A"+b+"B";
    }
    
    // Two passes
    public String getHintMine(String secret, String guess) {
        int a = 0, b = 0;
        
        int[] s = new int[10];
        int[] g = new int[10];
        
        for(int i = 0; i<secret.length(); i++){
            int chS = secret.charAt(i);
            int chG = guess.charAt(i);
            
            if(chS==chG) a++;
            else {
                s[chS-'0']++;
                g[chG-'0']++;
            }
        }
        
        for(int i = 0; i<10; i++){
            b += Math.min(s[i], g[i]);
        }
        return a+"A"+b+"B";
    }
}
