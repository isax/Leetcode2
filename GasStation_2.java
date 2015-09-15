// Still took some time and missed sth. But at least got some clue.
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int remainingGas = 0; 
        int start = 0;
        int curRemainingGas = 0;
        
        for(int i = 0; i<gas.length; i++){
            if(curRemainingGas<0) {
                start = i;
                curRemainingGas = 0;
            }
            remainingGas += gas[i] - cost[i];
            curRemainingGas += gas[i] - cost[i];
        }
        
        if(remainingGas>=0){
            return start;
        }else{
            return -1;
        }
    }
}
