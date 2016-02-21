public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = target;
        
        for(int i = 0; i<nums.length-2; i++){
            //if(i!=0 && nums[i]==nums[i-1]) continue;
            int l = i+1, r = nums.length-1;
            while(l<r){
                //if(l>i+1 && nums[l]==nums[l-1]) {
                //    l++;
                //    continue;
                //}
                int sum = nums[l]+nums[r]+nums[i];
                if(sum==target){
                    return target;
                }else if(sum>target){
                    r--;
                }else{
                    l++;
                }
                if(closest==target || Math.abs(sum-target)<Math.abs(closest-target)){
                    closest = sum;
                }
            }
        }
        return closest;
    }
}
