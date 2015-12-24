public class Solution {
    public int minCostII(int[][] costs) {
        if(costs.length==0 || costs[0].length==0) return 0;
        
        int n = costs.length;
        int k = costs[0].length;
        
        int [] cur = new int [k];
        int lastMin = 0, lastSecondMin = 0;
        
        for(int i = 1; i<=n; i++){
            int curMin = Integer.MAX_VALUE, curSecondMin = Integer.MAX_VALUE;
            for(int j = 0; j<k; j++){
                if(cur[j]!=lastMin){
                    cur[j] = lastMin + costs[i-1][j];
                }else{
                    cur[j] = lastSecondMin + costs[i-1][j];
                }
                
                if(cur[j]<=curMin){
                    curSecondMin = curMin;
                    curMin = cur[j];
                }else{
                    curSecondMin = Math.min(curSecondMin, cur[j]);
                }
            }
            lastMin = curMin;
            lastSecondMin = curSecondMin;
        }
        return lastMin;
    }
}
