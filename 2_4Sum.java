public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        
        for(int i = 0; i<nums.length-3; i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            
            for(int j = i+1; j<nums.length-2; j++){
                if(j!=i+1 && nums[j]==nums[j-1]) continue;
                
                int l = j+1, r = nums.length-1;
                while(l<r){
                    if(l>j+1 && nums[l]==nums[l-1]) {
                        l++;
                        continue;
                    }
                    if(nums[l]+nums[r]==target-nums[i]-nums[j]){
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[l], nums[r]);
                        lists.add(list);
                        l++; r--;
                    }else if(nums[l]+nums[r]>target-nums[i]-nums[j]){
                        r--;
                    }else{
                        l++;
                    }
                }
            }
        }
        return lists;
    }
}
