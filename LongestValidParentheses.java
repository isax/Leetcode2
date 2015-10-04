public class Solution {
    
    
    //Code Ganker: http://blog.csdn.net/linhuanmars/article/details/20439613
    public int longestValidParentheses(String s) {
        if(s.length()==0) return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        int curStart = 0;
        int max = 0;
        
        for(int i =0; i<s.length(); i++){
            if(s.charAt(i)==')'){
                if(stack.isEmpty()){
                    curStart = i+1;
                }else{
                    stack.pop();
                    if(stack.isEmpty()){
                        max = Math.max(max, i-curStart+1);
                    }else{
                        max = Math.max(max, i-stack.peek());
                    }
                }
            }else{
                stack.push(i);
            }
        }
        return max;
    }
    
    
    // https://leetcode.com/discuss/8092/my-dp-o-n-solution-without-using-stack
    public int longestValidParentheses1(String s) {
        if(s.length()==0) return 0;
        int[]dp = new int[s.length()];
        
        int max = 0; // dont forget
        
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)==')'){
                if(i>0 && s.charAt(i-1)=='('){
                    dp[i] = i>=2?dp[i-2]+2 : 2;
                }else if (i>0 && s.charAt(i-1)==')'){
                    if(i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1)=='(' ){
                        dp[i] = dp[i-1] + 2 + (i-dp[i-1]-2>=0?dp[i-dp[i-1]-2]:0);
                    } 
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
    
    public int longestValidParentheses2(String s) {
        if(s.length()==0) return 0;
        int[]dp = new int[s.length()];
        
        int max = 0; // dont forget
        
        for(int i = 1; i<s.length(); i++){
            if(s.charAt(i)==')'){
                if(i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1)=='(' ){
                    dp[i] = dp[i-1] + 2 + (i-dp[i-1]-2>=0?dp[i-dp[i-1]-2]:0);
                } 
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
