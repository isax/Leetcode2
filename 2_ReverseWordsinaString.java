public class Solution {
    // https://leetcode.com/discuss/3378/is-my-solution-good-enough
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i>=0;){
            while(i>=0 && s.charAt(i)==' ') i--;
            if(i<0) break;
            
            StringBuilder temp = new StringBuilder();
            while(i>=0 && s.charAt(i)!=' '){
                temp.append(s.charAt(i--)+"");
            }
            
            if(sb.length()!=0) sb.append(" ");
            sb.append(temp.reverse().toString());
        }
        return sb.toString();
    }
    
    public String reverseWordsMine(String s) {
        Stack<String> stack = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<=s.length(); i++){
            if(i==s.length() || s.charAt(i)==' ') {
                if(sb.length()!=0) {
                    stack.push(sb.toString());
                    sb = new StringBuilder(); // = =||||
                }
                continue;
            }else{
                sb.append(s.charAt(i)+"");
            }
        }
        
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            if(res.length()!=0) res.append(" ");
            res.append(stack.pop());
        }
        return res.toString();
    }
}
