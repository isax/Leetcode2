public class Solution {
    // ?? https://leetcode.com/discuss/71354/share-my-thinking-process
    
    // https://leetcode.com/discuss/72030/share-my-dp-solution-by-state-machine-thinking
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len==0) return 0;
        
        int [] s0 = new int[len];
        int [] s1 = new int [len];
        int [] s2 = new int [len];
        
        s1[0] = -prices[0];
        s2[0] = 0;
        
        int max = 0;
        for(int i = 1; i<len; i++){
            s0[i] = Math.max(s2[i-1], s0[i-1]);
            s1[i] = Math.max(s0[i-1] - prices[i], s1[i-1]);
            s2[i] = s1[i-1] + prices[i];
        }
        return Math.max(s0[len-1], s2[len-1]);
    }
    
    // https://leetcode.com/discuss/72030/share-my-dp-solution-by-state-machine-thinking
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len==0) return 0;
        
        int[] s0 = new int[len];
        int[] s1 = new int[len];
        int[] s2 = new int[len];
        
        s0[0] = 0; s1[0] = -prices[0]; s2[0] = Integer.MIN_VALUE;
        
        for(int i = 1; i<prices.length; i++){
            s0[i] = Math.max(s0[i-1], s2[i-1]);
            s1[i] = Math.max(s1[i-1], s0[i-1]-prices[i]);
            s2[i] = s1[i-1]+prices[i];
        }
        return Math.max(s0[len-1], s2[len-1]);
    }
}
