public class Solution {
     public int maxProfit(int[] prices) {
        int length = prices.length;
        if(prices==null || length==0) return 0;
        
        int sum = 0;
        for(int i = 0; i<length-1; i++){
            if(prices[i+1]>prices[i]){
                sum += prices[i+1] - prices[i];
            }
        }
        
        return sum;
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        
        if(len==0) return 0;
        
        int curValley = 0;
        int sumProfit = 0;
        
        for(int i=0; i<len-1; i++){
            if(prices[i]>prices[i+1]){
                if(curValley != i){
                    sumProfit += prices[i] - prices[curValley];
                }
                curValley = i+1;
            }
        }
        
        if(curValley != len-1){
            sumProfit += prices[len-1] - prices[curValley];
        }
        return sumProfit;
    }
}
