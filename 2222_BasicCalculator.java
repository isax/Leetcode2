public class Solution {
    // https://leetcode.com/discuss/77406/java-easy-version-to-understand
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int sign = 1;
        int cur = 0;
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)){
                int num = 0;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    num = num*10 + (s.charAt(i)-'0');
                    i++;
                }
                if(i!=s.length()) i--; // set to last digit
                cur += sign*num;
                continue;
            }else if(ch=='+' || ch=='-'){
                sign = ch=='+'?1:-1;
            }else if(ch=='('){
                stack.push(cur);
                stack.push(sign);
                cur = 0;
                sign = 1;
            }else if(ch==')'){
                cur = cur*stack.pop() + stack.pop();
            }
        }
        return cur;
    }
    
    public int calculateMine(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int sign = 1;
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)){
                int num = 0;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    num = num*10 + (s.charAt(i)-'0');
                    i++;
                }
                if(i!=s.length()) i--; // set to last digit
                int top = stack.isEmpty()?0:stack.pop();///////////////
                stack.push(top+sign*num);
                continue;
            }else if(ch=='+' || ch=='-'){
                sign = ch=='+'?1:-1;
            }else if(ch=='('){
                stack.push(sign);
                stack.push(0);
                sign = 1;
            }else if(ch==')'){
                int num = stack.pop()*stack.pop();
                if(!stack.isEmpty()) num += stack.pop();
                stack.push(num);
            }
        }
        return stack.pop();
    }
}
