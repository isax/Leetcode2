public class Solution {
    public boolean canJump(int[] nums) {
        int ability = nums[0];
        
        for(int i = 1; i<nums.length; i++){
            if(ability<i) return false;
            
            ability = i+nums[i]>ability? i+nums[i]:ability;
        }
        return true;
    }
    
    /*
    public boolean canJump(int[] nums) {
        
        int [] distances = new int [nums.length];
        
        for(int i = 0; i<nums.length; i++){
            distances[i] = nums[i] + i;
        }
        
        int curIndex = 0;
        
        while(curIndex < nums.length){
            int maxNextIndex = curIndex;
            int maxDistanceNextCanReach = distances[curIndex];
            
            for(int j = curIndex; j<=distances[curIndex] && j<nums.length; j++){
                if(distances[j]>=nums.length-1){
                    return true;
                }
                
                if(distances[j]>maxDistanceNextCanReach){
                    maxDistanceNextCanReach = distances[j];
                    maxNextIndex = j;
                }
            }
            
            if(distances[curIndex]==maxDistanceNextCanReach && distances[curIndex] != nums.length-1) {
                return false;
            }
            curIndex = maxNextIndex;
        }
        return false;
    }*/
}
