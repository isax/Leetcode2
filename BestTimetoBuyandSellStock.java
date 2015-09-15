public class Solution {
    public int maxProfit(int[] prices) {
        int globalProfix = 0;
        int localMin = Integer.MAX_VALUE; int localMax = Integer.MIN_VALUE;
        
        for(int i = 0; i<prices.length; i++){
            if(prices[i]<localMin){
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
