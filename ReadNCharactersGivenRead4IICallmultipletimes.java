/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    // https://leetcode.com/discuss/21219/a-simple-java-code
    private int bufferCount = 0;
    private int bufferPointer = 0;
    char [] buffer = new char[4];
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int count = 0;
        while(count<n){
            if(bufferPointer==bufferCount){
                bufferCount = read4(buffer);
                bufferPointer = 0;
            }
            
            while(count<n && bufferPointer<bufferCount){
                buf[count++] = buffer[bufferPointer++];
            }
            if(bufferCount<4) break;
        }
        return count;
    }
}
