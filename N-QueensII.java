public class Solution {
    public int totalNQueens(int n) {
        int [] sum = new int[1];
        helper(n, 0, new int[n], sum);
        return sum[0];
    }
    
    private void helper(int n, int curRow, int[] curList, int [] sum){
        if(curRow==n){
            sum[0]++;
            return;
        }
        
        for(int i = 0; i<n; i++){
            if(checkValid(curList, curRow, i)){
                curList[curRow] = i;
                helper(n, curRow+1, curList, sum);
            }
        }
    }
    
    private boolean checkValid(int[] curList, int i, int j){
        for(int row = 0; row<i; row++){
            if(curList[row]==j || Math.abs(curList[row]-j)==i-row){
                return false;
            }
        }
        return true;
    }
}
