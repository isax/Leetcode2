public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            ///////////sb.append(str.length()+"/"+str);
            sb.append(str.length()).append("/").append(str);
        }
        return sb.toString();
    }
    
    
    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new ArrayList<String>();
        int i = 0; 
        while(i<s.length()){
            int slash = s.indexOf("/", i);
            int len = Integer.parseInt(s.substring(i, slash));
            String str = s.substring(slash+1, slash+1+len);
            list.add(str);
            i = slash+1+len;
        }
        return list;
    }

    // Decodes a single string to a list of strings.
    public List<String> decodeMine(String s) {
        List<String> list = new ArrayList<String>();
        char [] chs = s.toCharArray();
        int i = 0; 
        while(i<s.length()){
            int len = 0;
            while(i<s.length() && chs[i]!='/'){
                len = len*10 + (int)(chs[i]-'0');
                i++;
            }
            i++; // jump to start of string
            StringBuilder sb = new StringBuilder();
            for(int j = i; j<i+len; j++){
                sb.append(chs[j]+"");
            }
            list.add(sb.toString());
            i = i+len;
        }
        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
