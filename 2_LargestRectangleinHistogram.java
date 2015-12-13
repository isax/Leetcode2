public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for(int i = 0; i<height.length; i++){
            while(!stack.isEmpty() && height[stack.peek()]> height[i]){
                int h = height[stack.pop()];
                int local = stack.isEmpty()?i:i-stack.peek()-1;
                max = Math.max(max, h*local);
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
