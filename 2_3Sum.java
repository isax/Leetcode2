public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        
        for(int i = 0; i<nums.length-2; i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            int l = i+1, r = nums.length-1;
            while(l<r){
                if(l>i+1 && nums[l]==nums[l-1]) {
                    l++;
                    continue;
                }
                if(nums[l]+nums[r]==-nums[i]){
                    List<Integer> list = Arrays.asList(nums[i], nums[l], nums[r]);
                    lists.add(list);
                    l++; r--;
                }else if(nums[l]+nums[r]>-nums[i]){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return lists;
    }
}
