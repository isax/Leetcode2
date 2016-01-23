public class Solution {
    // https://leetcode.com/discuss/69517/7ms-java-code-win-over-100%25
    
    // https://leetcode.com/discuss/32594/clean-accepted-java-o-n-3-solution-based-on-3sum
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length<4) return res;
        
        Arrays.sort(nums);
        
        for(int i = 0; i<nums.length-3; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            
            for(int j = i+1; j<nums.length-2; j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                
                int l=j+1, r=nums.length-1;
                while(l<r){
                    int sum=nums[i]+nums[j]+nums[l]+nums[r];
                    
                    if(sum==target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while(l<r&&nums[l]==nums[l+1])l++;
                        while(l<r&&nums[r]==nums[r-1])r--;
                        l++; r--;
                    }else if(sum<target){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
