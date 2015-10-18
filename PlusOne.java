public class Solution {
    // https://leetcode.com/discuss/58149/my-simple-java-solution
    public int[] plusOne(int[] digits) {
        
        for(int i = digits.length-1;i>=0; i--){
            if(digits[i]<9){
                digits[i] = digits[i]+1;
                return digits;
            }else{
                digits[i] = 0;
            }
        }
        
        // has to create a n+1 size array
        // 999999 all the way
        int [] res = new int[digits.length+1];
        res[0] = 1;
       
        return res;
    }
    
    public int[] plusOneMine(int[] digits) {
        Stack<Integer> stack = new Stack<Integer>();
        
        int i = digits.length-1;
        for(;i>=0; i--){
            if(digits[i]<9){
                stack.push(digits[i]+1);
                break;
            }else{
                stack.push(0);
            }
        }
        if(i==-1) i=0;
        if(stack.peek()==0) stack.push(1);
        
        int [] res = new int[i+stack.size()];
        for(int j = 0; j<i; j++){
            res[j] = digits[j];
        }
        for(int j = i; j<i+stack.size(); j++){
            res[j] = stack.pop();
        }
        return res;
    }
}
