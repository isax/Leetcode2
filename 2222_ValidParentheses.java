public class Solution {
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(!stack.isEmpty()&&match(stack.peek(), c)){
                stack.pop();
            }else{
                if(c==')' || c=='}' || c== ']') return false;
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c=='('||c=='{'||c=='[') {
                stack.push(c);
            }else{
                if(stack.isEmpty()||!match(stack.peek(), c)) return false;
                else stack.pop();
            }
        }
        return stack.isEmpty();
    }
    
    private boolean match(char a, char b){
        switch(a){
            case '(':
                return b==')';
            case '{':
                return b=='}';
            case '[':
                return b==']';
            default:
                return false;
        }
    }
    
    
}
