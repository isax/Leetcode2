public class Solution {
    //https://leetcode.com/discuss/61796/simple-o-n-2-two-pointers-java-solution
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        for(int i = 0; i<nums.length; i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            
            int target = 0 - nums[i];
            int l = i+1; int r = nums.length-1;
            while(l<r){
                if(nums[l]+nums[r]==target){
                    List<Integer> list = Arrays.asList(nums[i], nums[l], nums[r]);
                    res.add(list);
                    l++;
                    r--;
                    while(l<r&& nums[l]==nums[l-1]) l++;
                    //while(l<r&& nums[r]==nums[r+1]) r--;
                }else if(nums[l]+nums[r]<target){
                    l++;
                    while(l<r && nums[l]==nums[l-1]) l++;
                }else{
                    r--;
                    //while(l<r&& nums[r]==nums[r+1]) r--;
                }
            }
        }
        return res;
    }
}
