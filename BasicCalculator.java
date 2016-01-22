public class Solution {
    // https://leetcode.com/discuss/77406/java-easy-version-to-understand
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int sign = 1;
        int result = 0;
        
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                int num = s.charAt(i) - '0';
                while(i+1<s.length() && s.charAt(i+1)>='0' && s.charAt(i+1)<='9'){
                    i++;
                    num = num*10 + s.charAt(i) - '0';
                }
                result += sign*num;
            }else if(s.charAt(i)=='+'){
                sign = 1;
            }else if(s.charAt(i)=='-'){
                sign = -1;
            }else if(s.charAt(i)=='('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }else if(s.charAt(i)==')'){
                result = result*stack.pop() + stack.pop();
            }
        }
        return result;
    }
}
