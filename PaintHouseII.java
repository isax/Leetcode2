public class Solution {
    // https://leetcode.com/discuss/52982/c-dp-time-o-nk-space-o-k
    public int minCostII(int[][] costs) {
        int count = costs.length;
        if(count==0) return 0;
        
        int color = costs[0].length;
        
        int [] prev = new int[color];
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        int minOld = 0, secondMinOld = 0;
        
        for(int i = 0; i<count; i++){
            min = Integer.MAX_VALUE; // current 
            secondMin = Integer.MAX_VALUE;

            for(int k = 0; k<color; k++){
                if(prev[k]!=minOld){
                   prev[k] = minOld + costs[i][k]; 
                }else{
                   prev[k] = secondMinOld + costs[i][k];  
                }
                
                if(min<=prev[k]){
                    secondMin = Math.min(prev[k], secondMin);
                }else{
                    secondMin = min;
                    min = prev[k];
                }
            }
            minOld = min;
            secondMinOld = secondMin;
        }
        return min;
    }
    
    public int minCostIIMine(int[][] costs) {
        int count = costs.length;
        if(count==0) return 0;
        
        int color = costs[0].length;
        
        int [] prev = costs[0];
        for(int i = 1; i<count; i++){
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            
            for(int k = 0; k<color; k++){
                minIndex = min>prev[k]?k:minIndex;
                min = Math.min(min, prev[k]);
            }
            
            int secondMin = Integer.MAX_VALUE;
            int secondIndex = -1;
            
            for(int k = 0; k<color; k++){
                if(k!=minIndex){
                    secondIndex = secondMin>prev[k]?k:secondIndex;
                    secondMin = Math.min(secondMin, prev[k]);
                }
            }
            for(int k = 0; k<color; k++){
                if(k!=minIndex){
                   prev[k] = min + costs[i][k]; 
                }else{
                   prev[k] = secondMin + costs[i][k];  
                }
            }
        }
        
        int min = prev[0];
        for(int i = 1; i<color; i++){
            min = Math.min(min, prev[i]);
        }
        return min;
    }
}
