public class Solution {
    // Reference: http://blog.csdn.net/linhuanmars/article/details/20524507, 
    // http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> stack = new Stack<Integer>();
        int global = 0;
        
        for(int i = 0; i<len; i++){
            while(!stack.empty() && height[stack.peek()]>height[i]){
                int curHeight = height[stack.peek()];
                stack.pop();
                int width = stack.empty()? i : i - 1 - stack.peek();
                global = Math.max(global, width*curHeight);
            }
            stack.push(i);
        }
        
        while(!stack.empty()){
            int curHeight = height[stack.peek()];
            stack.pop();
            int width = stack.empty()? len : len - 1 - stack.peek();
            global = Math.max(global, width*curHeight);
        }
        return global;
    }
    
    
    // O(n^2) - TLE
    /*
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        int global = 0;
        
        for(int i = 0; i<len;i++){
            int curHeight = height[i];
            int width = 1;
            // go left
            for(int left = i-1; left>=0; left--){
                if(height[left]>=curHeight){
                    width++;
                }else{
                    break;
                }
            }
            
            // go right
            for(int right = i+1; right<len; right++){
                if(height[right]>=curHeight){
                    width++;
                }else{
                    break;
                }
            }
            global = Math.max(global, width*curHeight);
        }
        return global;
    }*/
}
