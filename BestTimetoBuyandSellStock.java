public class Solution {
    // code ganker: http://blog.csdn.net/linhuanmars/article/details/23162793
    public int maxProfit(int[] prices){
        int global = 0;
        int local = 0;
        
        for(int i = 0; i<prices.length-1; i++){
            local += prices[i+1] - prices[i];
            if(local<0){
                local = 0;
            }
            global = Integer.max(global, local);
        }
        return global;
    }
    
    // My own solution: local and global solution
    public int maxProfit2(int[] prices) {
        int globalProfix = 0;
        int localMin = Integer.MAX_VALUE; int localMax = Integer.MIN_VALUE;
        
        for(int i = 0; i<prices.length; i++){
            if(prices[i]<localMin){ // the same as cur profit sum < 0
                localMin = prices[i];
                localMax = prices[i];
            }
            
            if(prices[i]>localMax){
                localMax = prices[i];
            }
            
            globalProfix = Math.max(globalProfix, localMax-localMin);
        }
        return globalProfix;
    }
}
