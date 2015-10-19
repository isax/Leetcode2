public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<String>();
        
        for(int i = 0; i<s.length()-1; i++){
            if(s.charAt(i) =='+' && s.charAt(i+1)=='+'){
                //char[] str = s.toCharArray();
                //str[i] = '-'; str[i+1] = '-';
                String str = s.substring(0, i) + "--" + s.substring(i+2);
                res.add(new String(str));
            }
        }
        return res;
    }
}
