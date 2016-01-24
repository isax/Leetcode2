public class Solution {
    // https://leetcode.com/discuss/70124/0ms-concise-solution-perfectly-handles-the-follow-leading
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        
        for(int i = 1; i<=len/2; i++){
            for(int j = 1; j<=(len-i)/2; j++){
                if(check(num.substring(0, i), num.substring(i, i+j), num.substring(i+j))) return true;
            }
        }
        return false;
    }
    
    private boolean check(String num1, String num2, String num){
        if(num1.length()>1 && num1.charAt(0)=='0' || num2.length()>1 && num2.charAt(0)=='0') return false;
        String sum = add(num1, num2);
        if(sum.equals(num)) return true;
        
        if(num.length()<=sum.length() || !num.substring(0, sum.length()).equals(sum)) return false;
        return check(num2, sum, num.substring(sum.length()));
    }
    
    private String add(String a, String b){
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        
        while(i>=0 || j>=0 || carry==1){
            int sum = carry + (i>=0?a.charAt(i--)-'0':0) + (j>=0?b.charAt(j--)-'0':0);
            res.append(sum%10);
            carry = sum/10;
        }
        return res.reverse().toString();
    }
}
