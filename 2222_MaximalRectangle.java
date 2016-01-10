public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        
        int [] height = new int[col];
        int max = 0;
        
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                height[j] = matrix[i][j]=='0'?0:height[j]+1;
            }
            max = Math.max(max, largestRectangle(height));
        }
        return max;
    }
    
    private int largestRectangle(int []height){
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        
        for(int i = 0; i<height.length; i++){
            while(!stack.isEmpty() && height[i]<height[stack.peek()]){
                int h = height[stack.pop()];
                int local = stack.isEmpty()?i:i-stack.peek()-1;
                max = Math.max(max, local*h);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int h = height[stack.pop()];
            int local = stack.isEmpty()?height.length:height.length-stack.peek()-1;
            max = Math.max(max, local*h); 
        }
        return max;
    }
}
