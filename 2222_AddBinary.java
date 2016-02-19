public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int add = 0;
        for(int i = a.length()-1, j = b.length()-1; i>=0||j>=0 || add!=0; i--, j--){
            int m = i>=0?a.charAt(i)-'0':0;
            int n = j>=0?b.charAt(j)-'0':0;
            int sum = m+n+add;
            add = sum>1?1:0;
            sb.append(sum%2);
        }
        sb.reverse();
        return new String(sb);
    }
}
