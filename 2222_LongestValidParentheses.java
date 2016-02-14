public class Solution {
    // https://leetcode.com/discuss/8092/my-dp-o-n-solution-without-using-stack
    public int longestValidParenthesesDP(String s) {
        int len = s.length();
        int [] dp = new int[len];
        
        int max = 0;
        for(int i = 1; i<len; i++){
            if(s.charAt(i)=='(') continue;
            
            if(s.charAt(i-1)=='('){
                dp[i] = 2 + (i>=2?dp[i-2]:0);
            }else{
                int match = i-1-dp[i-1];
                if(match>=0 && s.charAt(match)=='('){
                    dp[i] = dp[i-1] + 2 + (match-1>=0?dp[match-1]:0);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    
    // Code Ganker: http://blog.csdn.net/linhuanmars/article/details/20439613
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int len = s.length();
        int max = 0;
        int start = 0;
        for(int i = 0; i<len; i++){
            if(s.charAt(i)=='(') {
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                    start = i+1;
                }else{
                    stack.pop();
                    max = stack.isEmpty()?Math.max(max, i-start+1):Math.max(max, i-stack.peek());
                }
            }
        }
        return max;
    }
}
