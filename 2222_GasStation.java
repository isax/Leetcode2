public class Solution {
     // http://blog.csdn.net/linhuanmars/article/details/22706553
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int curAbility = 0;
        int start = 0;
        for(int i = 0; i<cost.length; i++){
            if(curAbility<0){
               start = i;
               curAbility = 0;
            }
            total += gas[i] - cost[i];
            curAbility += gas[i] - cost[i];
        }
        
        if(total<0) return -1;
        else return start;
    }
}
