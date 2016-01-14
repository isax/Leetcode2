public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0 ||matrix[0].length==0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        
        int [] cur = new int[col];
        int max = 0;
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(matrix[i][j]!='0'){
                    cur[j]++;
                }else{
                    cur[j] = 0;
                }
            }
            int local  = getMaxHistogram(cur);
            max = Math.max(max, local);
        }
        return max;
    }
    
    private int getMaxHistogram(int[]row){
        Stack<Integer> stack = new Stack<Integer>();
        
        int max = 0;
        for(int i = 0; i<row.length; i++){
            while(!stack.isEmpty() && row[i]<row[stack.peek()]){
                int j = stack.pop();
                // WRONG: int wide = stack.isEmpty()?j+1:j-stack.peek();
                int wide = stack.isEmpty()?i:i-1-stack.peek();
                int area = row[j] * wide;
                max = Math.max(area, max);
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int j = stack.pop();
            int wide = stack.isEmpty()?row.length:row.length-1-stack.peek();
            int area = row[j] * wide;
            max = Math.max(area, max);
        }
        return max;
    }
}
