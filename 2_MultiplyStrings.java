public class Solution {
    
    // good explanation: https://leetcode.com/discuss/33951/ac-solution-in-java-with-explanation
    
    // https://leetcode.com/discuss/71593/easiest-java-solution-with-graph-explanation
    
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        char [] chs1 = num1.toCharArray();
        char [] chs2 = num2.toCharArray();
        
        int [] res = new int[len1+len2];
        for(int i = len1-1; i>=0; i--){
            for(int j = len2-1; j>=0; j--){
                int cur = (chs1[i] - '0') * (chs2[j] - '0');
                int sum = res[i+j+1] + cur;
                res[i+j] += sum/10;
                res[i+j+1] = sum%10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<res.length; i++){
            if(i!=res.length-1 && sb.length()==0 && res[i]==0) continue;
            sb.append(res[i]);
        }
        return sb.toString();
    }
    
    public String multiplyMine(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        char [] chs1 = num1.toCharArray();
        char [] chs2 = num2.toCharArray();
        
        int [] res = new int[len1+len2];
        for(int i = len1-1; i>=0; i--){
            int add = 0;
            for(int j = len2-1; j>=0; j--){
                int cur = (chs1[i] - '0') * (chs2[j] - '0');
                int sum = res[i+j+1] + cur + add;
                add = sum/10;
                res[i+j+1] = sum%10;
            }
            res[i] = add;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<res.length; i++){
            if(i!=res.length-1 && sb.length()==0 && res[i]==0) continue;
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
