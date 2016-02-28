/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    char [] buffer = new char[4];
    int len = 0;
    int pos = 0;
    
    public int read(char[] buf, int n) {
        int count = 0;
        while(count < n){
            if(pos==len){ // need to read
                len = read4(buffer);
                pos = 0;
            }
            while(pos<len && count<n){
                buf[count++] = buffer[pos++];
            }
            if (len < 4) break;
        }
        return count;
    }
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int readMine(char[] buf, int n) {
        int count = 0;
        while(pos<len && count<n){ // sth can be read from buffer
            buf[count++] = buffer[pos++];
        }
        boolean isEof = false;
        while(count < n && !isEof){
            len = read4(buffer);
            if (len < 4){
                isEof = true;
            }
            
            for(pos = 0; pos<len && count<n; pos++, count++){
                buf[count] = buffer[pos];
            }
        }
        return count;
    }
}
