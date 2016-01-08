public class Solution {
    // dp
    // https://leetcode.com/discuss/76217/java-both-iterative-recursive-solutions-with-explanations
    public int coinChange(int[] coins, int amount) {
        int [] dp = new int[amount+1];
        
        for(int i = 1; i<=amount; i++){
            int curMin = -1;
            for(int j = 0; j<coins.length; j++){
                int remain = i-coins[j];
                if(remain<0 || dp[remain]==-1){
                    continue;
                }else{
                    curMin = curMin == -1? dp[remain]+1 : Math.min(curMin, dp[remain]+1);
                }
            } 
            dp[i] = curMin;
        }
        return dp[amount];
    }
    
    // https://leetcode.com/discuss/76194/c-o-n-amount-time-o-amount-space-dp-solution
    public int coinChangeBacktracking(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] res= new int[1];
        res[0] = -1;
        helper(coins, coins.length-1, amount, 0, res);
        return res[0];
    }
    
    private void helper(int[]coins, int curCoin, int amount, int count, int[]res){
        if(curCoin<0){
            return;
        }
        int number = amount/coins[curCoin];
        
        for(int i=number;i>=0;i--){
            int remain=amount-coins[curCoin]*i;
            
            if(remain>0 && (res[0]==-1 || count+i<res[0])){
                helper(coins, curCoin-1, remain, count+i, res);
            }else if(remain==0) {
                res[0] = res[0]==-1?count+i : Math.min(count+i, res[0]);
            }else{ // count+i>res[0], no need to dfs
                break;
            }
        }
    }
}
