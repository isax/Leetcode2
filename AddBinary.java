public class Solution {
    public String addBinary(String a, String b) {
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = ac.length-1, j = bc.length-1;
        while((i>=0 || j>=0) || carry!=0){
            int l = i>=0?(ac[i--]-'0'):0;
            int r = j>=0?(bc[j--]-'0'):0;
            
            //int cur = (l+r+carry)%2;
            int cur = l^r^carry;
            sb.append(cur);
            //carry = (l+r+carry)/2;
            carry = ((l + r + carry) >= 2) ? 1 : 0;
        }
        
        return sb.reverse().toString();
    }
}
