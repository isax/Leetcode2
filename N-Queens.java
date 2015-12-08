public class Solution {
    
    // http://blog.csdn.net/linhuanmars/article/details/20667175
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new ArrayList<List<String>>();
        int [] curList = new int[n];
        helper(n, 0, curList, lists);
        return lists;
    }
    
    private void helper(int n, int cur, int [] curList, List<List<String>> lists){
        if(cur==n){
            List<String> list = new ArrayList<String>();
            for(int i = 0; i<n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j<n; j++){
                    if(j==curList[i]){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            lists.add(list);
            return;
        }
        
        for(int i = 0; i<n; i++){
            if(checkValid(cur, i, curList)){
                curList[cur] = i;
                helper(n, cur+1, curList, lists);
                // no reset
            }
        }
    }
    
    private boolean checkValid(int i, int j, int [] list){
        for(int row = 0; row<i; row++){
            if(list[row]==j || Math.abs(j-list[row]) == i-row){
                return false;
            }
        }
        return true;
    }
}
