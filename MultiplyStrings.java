public class Solution {
    
    // good explanation: https://leetcode.com/discuss/33951/ac-solution-in-java-with-explanation
    
    // https://leetcode.com/discuss/71593/easiest-java-solution-with-graph-explanation
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        
        
        for(int i = num1.length()-1; i>=0; i--){
            for(int j = num2.length()-1; j>=0; j--){
                int d1 = num1.charAt(i)-'0';
                int d2 = num2.charAt(j)-'0';
                
                int sum = d1*d2 + res[i+j+1];
                
                res[i+j] += sum/10;
                res[i+j+1] = sum%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<res.length; i++){
            if(sb.length()==0 && res[i]==0) continue;
            sb.append(res[i]);
        }
        return sb.length()==0?"0":sb.toString();
    }
}
