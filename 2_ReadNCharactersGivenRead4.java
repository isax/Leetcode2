/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int total = 0;
        boolean reachEnd = false;
        while(total<n && !reachEnd){
            char[] cache = new char[4];
            int count = read4(cache);
            if(count<4) reachEnd = true;
            
            for(int i = 0;total<n && i<count; i++,total++){
                buf[total] = cache[i];
            }
        }
        return total;
    }
}
