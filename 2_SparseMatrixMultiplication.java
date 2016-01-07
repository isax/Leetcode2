public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if(A.length==0 || B.length==0 || A[0].length==0 || B[0].length==0) return null;
        int [][] res = new int[A.length][B[0].length];
        
        for(int i = 0; i<A.length; i++){
            for(int j = 0; j<A[0].length; j++){
                if(A[i][j]!=0){
                    for(int bCol = 0; bCol<B[0].length; bCol++){
                        res[i][bCol] += A[i][j]*B[j][bCol]; 
                    }
                }
            }
        }
        return res;
    }
}
