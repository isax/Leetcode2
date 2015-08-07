public class Solution {
    // dp
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0) return 0;
        
        int row = matrix.length;
        int col = matrix[0].length;
        int [][] cache = new int[row][col];
        
        int global = 0;
        
        for (int j = 0; j < col; j++) {
            cache[0][j] = matrix[0][j] - '0';
            global = Math.max(global, cache[0][j]);
        }
	
	   	for (int i = 0; i < row; i++) {
	   	    cache[i][0] = matrix[i][0] - '0';
	   	    global = Math.max(global, cache[i][0]);
	   	}
        
        
        for(int i = 1; i<row; i++){
            for(int j = 1; j<col; j++){
                cache[i][j] = matrix[i][j] == '0' ? 0 : Math.min(cache[i-1][j], Math.min(cache[i][j-1], cache[i-1][j-1])) + 1;
                global = Math.max(global, cache[i][j]);
            }
        }
        return global*global;
    }

    // similar method to maximal rectangle
    int global = 0;
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int [] cache = new int[col];
        
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
               if(i==0){ // first line
                   cache[j] = matrix[i][j] - '0';
               }else{
                   cache[j] = matrix[i][j]=='0'? 0: cache[j]+1;
               }
            }
            getMax(cache);
        }
        return global;
    }
    private void getMax(int [] array){
        
        Stack<Integer>stack = new Stack<Integer>();
        
        int [] array_helper = new int[array.length+1];
        for(int i = 0; i< array.length; i++){
            array_helper[i] = array[i];
        }
        array_helper[array.length] = 0;
        
        for(int i = 0; i<array_helper.length; i++){
            while(!stack.isEmpty() && array_helper[i] <= array_helper[stack.peek()] ){ // has to be <=
                int poppedHeight = array_helper[stack.peek()];
                stack.pop();
                
                // check if the gap between the current i and the current peek is enough. the index between current peek and i are all > old peek. which is able to make a big square out of old peek
                int width = stack.isEmpty() ? i: i - stack.peek() - 1;
                
                //global = Math.max(global, Math.min(poppedHeight,width)*Math.min(poppedHeight,width));
                if(poppedHeight<=width){
                    global = Math.max(global,poppedHeight*poppedHeight);
                }
            }
            stack.push(i);
        }
        
    }
}
