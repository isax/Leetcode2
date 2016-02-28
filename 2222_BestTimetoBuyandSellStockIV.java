public class Solution {
    // http://blog.csdn.net/feliciafay/article/details/45128771
    // http://blog.csdn.net/linhuanmars/article/details/23236995
    public int maxProfit(int k, int[] prices) {
        if(prices==null || prices.length==0) return 0;  
        
        // validate input 2 : if k is large enough, the question will be the same as question II.
        if (k >= prices.length / 2) {  
            int result = 0;  
            for (int i = 1; i < prices.length; ++i) {  
                if (prices[i] - prices[i - 1] > 0) {  
                    result += prices[i] - prices[i - 1];  
                }  
            }  
            return result;  
        } 
        
        int[][] local = new int[prices.length][k+1]; // local[x][0] = 0, local[0][x] = 0 - 0 transactions makes 0 profit
        int[][] global = new int[prices.length][k+1]; // global[x][0] = 0, global[0][x] = 0
        
        for(int i=1;i<prices.length;i++){
            int diff = prices[i] - prices[i-1];
            
            for(int j=1;j<=k;j++) {  
                local[i][j]= Math.max(local[i-1][j] + diff,   global[i-1][j-1] + Math.max(0, diff));  
                global[i][j] = Math.max(local[i][j], global[i-1][j]);  
            } 
        }
        return global[prices.length-1][k];
    }
}
