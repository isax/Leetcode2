public class Solution {
    // http://blog.csdn.net/linhuanmars/article/details/19712011
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        
        for(int i = 0; i<nums.length-2; i++){
            int cur = getDiff(nums, i+1, target-nums[i]);
            if(Math.abs(closest)>Math.abs(cur))
              closest = cur;
        }
        return target+closest;
    }
    
    private int getDiff(int[]nums, int s, int target){
        int l = s, r = nums.length-1;
        int closest = Integer.MAX_VALUE;
        while(l<r){
            int curSum = nums[l] + nums[r];
            int curDiff = curSum - target;
            if(curDiff==0){
                return 0;
            }
            
            if(Math.abs(curDiff)<Math.abs(closest)){
                closest = curDiff;
            }
            
            if(curDiff>0) {
                r--;
            }else{
                l++;
            }
        }
        return closest;
    }
}
