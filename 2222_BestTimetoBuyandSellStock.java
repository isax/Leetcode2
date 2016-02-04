public class Solution {
    // http://blog.csdn.net/linhuanmars/article/details/23162793
    public int maxProfit(int[] prices) {
        int global = 0;
        int local = 0;
        
        for(int i = 1; i<prices.length; i++){
            local += prices[i]-prices[i-1];
            if(local<0) local = 0;
            global = Math.max(local, global);
        }
        return global;
    }
    
    public int maxProfitMine(int[] prices) {
        int max = 0;
        int minPrice = 0;
        
        for(int i = 1; i<prices.length; i++){
            if(prices[i]>=prices[minPrice] || i==prices.length-1){
                max = Math.max(max, prices[i] - prices[minPrice]);
            }else{
                minPrice = i;
            }
        }
        return max;
    }
}
