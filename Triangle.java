public class Solution {
    // Leave bottom up solution to next time
   
    // top down
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] pre = new int[1];
        
        pre[0] = triangle.get(0).get(0);
        for(int i = 1; i<row; i++){
            List<Integer>curList = triangle.get(i);
            int []cur = new int[i+1];
            cur[0] = pre[0] + curList.get(0);
            cur[i] = pre[i-1] + curList.get(i); 
            for(int col = 1; col<i; col++){
                cur[col]= pre[col-1] < pre[col] ? (pre[col-1]+curList.get(col)) : (pre[col]+curList.get(col));
            }
            pre = cur;
        }
        
        int min = pre[0];
        for(int i = 0; i<row; i++){
            min = pre[i]<min? pre[i]:min;  
        }
        
        return min;
    }
    
    // right -> left
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] res = new int[row];
        
        res[0] = triangle.get(0).get(0);
        for(int i = 1; i<row; i++){
            List<Integer>curList = triangle.get(i);
            res[i] = res[i-1] + curList.get(i); 
            for(int col = i-1; col>0; col--){
                res[col]= res[col-1] < res[col] ? (res[col-1]+curList.get(col)) : (res[col]+curList.get(col));
            }
            res[0] = res[0] + curList.get(0);
        }
        
        int min = res[0];
        for(int i = 1; i<row; i++){
            min = Math.min(min, res[i]);  
        }
        
        return min;
    }
}
