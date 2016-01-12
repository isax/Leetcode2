public class Codec {

    // https://leetcode.com/discuss/55020/ac-java-solution
    
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            int size = s.length();
            sb.append(size).append("/").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<String>();
        int cur = 0;
        while(cur<s.length()){
            int slash = s.indexOf("/", cur);
            int size = Integer.parseInt(s.substring(cur, slash));
            res.add(s.substring(slash+1, slash+1+size));
            cur = slash+1+size;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
