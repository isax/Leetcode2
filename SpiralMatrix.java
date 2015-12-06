public class Solution {
    
    // https://leetcode.com/discuss/12228/super-simple-and-easy-to-understand-solution
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if(matrix==null || matrix.length==0) return list;
        int m = matrix.length; int n = matrix[0].length;
        
        int rowBegin = 0;
        int rowEnd = m-1;
        int colBegin = 0;
        int colEnd = n-1;
        
        while(rowBegin<=rowEnd && colBegin<=colEnd){
            // upper row
            for(int col = colBegin; col<=colEnd;col++){
                list.add(matrix[rowBegin][col]);
            }
            rowBegin++;
            
            // right col
            for(int row = rowBegin; row<=rowEnd; row++){
                list.add(matrix[row][colEnd]);
            }
            colEnd--;
            
            // low row
            if(rowBegin<=rowEnd){
                for(int col = colEnd; col>=colBegin; col--){
                    list.add(matrix[rowEnd][col]);
                }
                rowEnd--;
            }
            
            // left col
            if(colBegin<=colEnd){
                for(int row = rowEnd; row>=rowBegin; row--){
                    list.add(matrix[row][colBegin]);
                }
                colBegin++;
            }
        }
        return list;
    }
}
