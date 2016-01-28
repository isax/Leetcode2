public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i<tokens.length; i++){
            String token = tokens[i];
            if(isOperator(token)){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(compute(a, b, token.charAt(0)));
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    
    private boolean isOperator(String token){
        if(token.length()!=1) return false;
        
        char ch = token.charAt(0);
        return ch=='+' || ch=='-' || ch=='*' || ch=='/';
    }
    
    private int compute(int a, int b, char op){
        switch(op){
            case '+': 
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
        }
        return Integer.MIN_VALUE;
    }
}
