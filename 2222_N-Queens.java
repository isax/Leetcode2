public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        int [] cur = new int[n];
        helper(0, n, cur, res);
        return res;
    }
    
    private void helper(int row, int n, int[] cur, List<List<String>> res){
        if (row==n) {
            List<String>list = new ArrayList<String>();
            for (int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++){
                    if(cur[i] == j){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        
        for(int i = 0; i<n; i++){
            if(isValid(row, i, cur)){
                cur[row] = i;
                helper(row+1, n, cur, res);
            }
        }
    }
    
    private boolean isValid(int row, int col, int[]cur){
        for(int i = 0; i<row; i++){
            if(cur[i]==col || Math.abs(cur[i]-col)==Math.abs(i-row)){
                return false;
            }
        }
        return true;
    }
}
