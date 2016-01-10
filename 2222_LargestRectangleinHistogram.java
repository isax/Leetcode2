public class Solution {
    public int largestRectangleArea(int[] height) {
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i<height.length; i++){
            while(!stack.isEmpty() && height[stack.peek()]>height[i]){
                int h = height[stack.pop()];
                int local = stack.isEmpty()?i:i-stack.peek()-1; // i-stack.peek()-1 ---- 1 5 2 3 stack: 1, 2, 3
                // stack empty: 4 3 2 1 stack: 2 
                // before any item in stack, nothing lower than the current item, so can use i*h
                max = Math.max(max, local*h);
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int h = height[stack.pop()];
            max = Math.max(max, h*(stack.isEmpty()?height.length:height.length-stack.peek()-1));
        }
        return max;
    }
}
