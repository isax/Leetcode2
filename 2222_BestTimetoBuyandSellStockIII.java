public class Solution {
    
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len==0) return 0;
        
        int [][] local = new int[len][3];
        Arrays.fill(local[0], -prices[0]);
        int [][] global = new int[len][3];
        
        for(int i = 1; i<len; i++){
            int diff = prices[i]-prices[i-1];
            
            for(int j = 1; j<3; j++){
                local[i][j] = Math.max(global[i-1][j-1] + Math.max(0, diff), local[i-1][j]+diff);
                global[i][j] = Math.max(global[i-1][j], local[i][j]);
            }
        }
        return global[len-1][2];
    }

    
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
