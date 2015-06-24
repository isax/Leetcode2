public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int curStart = 0;
        int availableGas = 0;
        
        for(int point = 0; point<len*2; point++){
            if(availableGas<0) {
                curStart = point;
                availableGas = 0;
            }
            //if(point-curStart == gas.length) break;
            availableGas += gas[point%len] - cost[point%len];
        }
        
        if(curStart>len-1){
            return -1;
        }else{
            return curStart;
        }
    }
    
    /**
      * if sum[i...j] <0, there wont be a possible start point k in [i...j]:  
      * suppose there is a k, [i...k...j-1,j]. Starting from i, leftGas_i[k]>=leftGas_k[k]. 
      * If starting from i can not make j, neither can starting from k.
      *
      * Another thought: if k can make it, it means sum[k, j] > 0, sum[i, k-1] < 0. 
      * It contradicts with the fact that i can make j-1. It could not even reach k-1.
      */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        
        int curStart = 0;
        int currentLeftGas = 0;
        int totalLeftGas = 0;
        
        for(int point = 0; point<len; point++){
            currentLeftGas += gas[point] - cost[point];
            totalLeftGas += gas[point] - cost[point];
            
            if(currentLeftGas<0) {
                curStart = point + 1;
                currentLeftGas = 0;
            }
        }
        
        if(totalLeftGas>=0){
            return curStart;
        }else{
            return -1;
        }
        
    }

}
