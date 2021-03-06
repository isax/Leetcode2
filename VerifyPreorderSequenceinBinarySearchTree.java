public class Solution {
    
    // NEED TO REVISIT: https://leetcode.com/discuss/51543/java-o-n-and-o-1-extra-space
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<Integer>();
        
        int low = Integer.MIN_VALUE;
        
        for(int i = 0; i<preorder.length; i++){
            if(preorder[i]<low){
                return false;
            }
            
            while(!stack.isEmpty() && stack.peek()<preorder[i]){
                low = stack.pop();
            }
            stack.push(preorder[i]);
        }
        return true;
    }
}
