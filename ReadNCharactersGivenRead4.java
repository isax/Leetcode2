/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    // https://leetcode.com/discuss/44743/another-accepted-java-solution
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int total = 0;
        boolean eof = false;
        
        while(!eof && total<n){
            char [] tmp = new char[4];
            int cur = read4(tmp);
            eof = cur<4;
            
            cur = Math.min(cur, n-total);
            
            for(int i = 0; i<cur; i++){
                buf[total++] = tmp[i];
            }
        }
        return total;
    }
}
