public class Solution {
    // https://leetcode.com/discuss/22592/java-10-lines-solution-with-stack
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        
        String[] s = path.split("/");
        for(int i = 0; i<s.length; i++){
            if(s[i].equals("..")){
                if(!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            // skip these
            if(!s[i].equals("") && !s[i].equals(".")) stack.push(s[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(String str : stack){
            sb.append("/").append(str);
        }
        if(stack.isEmpty()) sb.append("/");
        return sb.toString();
    }
}
