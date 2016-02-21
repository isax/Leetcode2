public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i<tokens.length; i++){
            String cur = tokens[i];
            if(isOp(cur)){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(calculate(cur.charAt(0), a, b));
            }else{
                stack.push(Integer.parseInt(cur));
            }
        }
        return stack.pop();
    }
    
    private boolean isOp(String cur){
        if(cur.length()!=1) {
            return false;
        }
        char token = cur.charAt(0);
        return token=='+'|| token=='*' || token=='-'|| token=='/';
    }
    
    private int calculate(char op, int a, int b){
        switch(op){
            case '+':
                return a+b;
            case '*':
                return a*b;
            case '-':
                return a-b;
            case '/':
                return a/b;
        }
        return Integer.MIN_VALUE;
    }
}
