public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i<s.length(); i++){
            char cur = s.charAt(i);
            
            if(isLeft(cur)) {
              stack.push(cur);
            }else{
              if(stack.isEmpty()) {
                  return false;
              }
              char top = stack.peek();
              if(match(top, cur)){
                  stack.pop();
              }else{
                  return false;
              }  
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
    
    private boolean match(char c, char t){
        if(c=='(' &&t==')') return true;
        if(c=='[' &&t==']') return true;
        if(c=='{' &&t=='}') return true;
        
        return false;
    }
    
    private boolean isLeft(char c){
        if(c=='(' || c=='[' || c=='{') return true;
        else return false;
    }
}
