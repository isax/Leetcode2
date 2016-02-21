public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        
        for(int i = 0; i<nums.length-2; i++){
            int l = i+1, r = nums.length-1;
            while(l<r){
                if(nums[l]+nums[r] < target - nums[i]){
                    res += r - l;
                    l++;
                }else {
                   r--;
                }
            }
        }
        return res;
    }
}
