public class Solution {
    
    // Other solutions: 
    // https://leetcode.com/discuss/48151/my-c-solution-o-n-time-o-1-space-8ms
    // https://leetcode.com/discuss/18330/is-it-best-solution-with-o-n-o-1
    
    // http://blog.csdn.net/linhuanmars/article/details/23236995
    public int maxProfit(int[] prices) {
        int [] local = new int[3];
        int [] global = new int[3];
        
        for(int i=0;i<prices.length-1;i++) {  
            int diff = prices[i+1]-prices[i];
            
            for(int j = 2; j>=1; j--){
                local[j] = Math.max(global[j-1] + Math.max(0, diff), local[j]+diff);
                global[j] = Math.max(global[j], local[j]);
            }
        }
        return global[2];
    }
}
