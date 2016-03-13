public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder.length==0) return true;
        Stack<Integer> stack = new Stack<Integer>();
        int lower = Integer.MIN_VALUE;
        for(int i : preorder){
            while(!stack.isEmpty() && i>stack.peek()){
                lower = stack.pop(); 
            }
            if(i<lower) return false;
            else stack.push(i);
        }
        return true;
    }
    
    
    // // NEED TO REVISIT: https://leetcode.com/discuss/51543/java-o-n-and-o-1-extra-space
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<Integer>();
        
        int low = Integer.MIN_VALUE;
        for(int i = 0; i<preorder.length; i++){
            if(preorder[i]<low) return false;
            
            while(!stack.isEmpty() && preorder[i]>stack.peek()){
                low = stack.pop();
            }
            
            stack.push(preorder[i]);
        }
        
        return true;
    }
}
