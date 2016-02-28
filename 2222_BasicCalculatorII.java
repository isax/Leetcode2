public class Solution {
    // https://github.com/isax/Leetcode2/blob/master/BasicCalculatorII.java
    public int calculate(String s) {
        int res = 0, cur = 0;
        char preSign = '+';
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch==' ') continue;
            
            if(Character.isDigit(ch)) { // number
                int start = i;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    i++;
                }
                int num = Integer.parseInt(s.substring(start, i));
                i--;
                
                if(preSign=='*') {
                    cur *= num;
                }else if (preSign=='/') {
                    cur /= num;
                }else if (preSign=='+') {
                    res += cur;
                    cur = num;
                }else{
                    res += cur;
                    cur = -num; 
                }
            }else {
                preSign = ch;
            }
        }
        return res + cur;
    }
}
