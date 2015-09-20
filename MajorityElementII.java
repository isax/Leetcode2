public class Solution {
    // https://leetcode.com/discuss/43248/boyer-moore-majority-vote-algorithm-and-my-elaboration
    // http://www.wengweitao.com/leetcode-majority-element-ii.html
    public List<Integer> majorityElement(int[] nums) {
        if(nums.length==0) return new ArrayList<Integer>();
        int count1 = 0, count2 = 0;
        int candidate1 = 0, candidate2 = 0;
        
        for(int i = 0; i<nums.length; i++){
            if(count1==0) {
                candidate1 = i; 
            }
            if(count2==0){
                candidate2 = i;
            }
            
            if(nums[candidate1]==nums[i]) count1++;
            else if(nums[candidate2]==nums[i]) count2++;
            
            if(nums[candidate1]!=nums[i] && nums[candidate2]!=nums[i]){
                count1--;
                count2--;
            }
        }
        
        count1 = 0; count2 = 0;
        for(int i : nums){
            if(nums[candidate1]==i) count1++;
            if(nums[candidate2]==i) count2++;
        }
        
        List<Integer> res = new ArrayList<Integer>();
        if(count1>nums.length/3) res.add(nums[candidate1]);
        if(nums[candidate1]!=nums[candidate2]&&count2>nums.length/3) res.add(nums[candidate2]);
        
        return res;
    }
}
