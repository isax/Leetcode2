public class Solution {
    
    // fancy
    // https://leetcode.com/discuss/61514/understood-solution-space-without-modifying-explanation
    public int findDuplicate(int[] nums) {
        int fast = nums[nums[0]], slow = nums[0]; // 0 can't be the start of the loop, so safe
        
        while(fast!=slow){ /// fast = nums[nums[0]]!!!!
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        
        fast = 0;
        while(fast!=slow){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
     } 
    public int findDuplicateBetter(int[] nums) {
        int fast = 0, slow = 0; // 0 can't be the start of the loop, so safe
        
        while(fast==0 || fast!=slow){ /// fast = nums[nums[0]]!!!!
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        
        fast = 0;
        while(fast!=slow){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
     } 
    
    public int findDuplicate2(int[] nums) {
        int l = 0, r = nums.length-1;
        
        while(l<r){
            int mid = (l+r)/2;
            if(countLess(nums, mid)>mid) r = mid;
            else l = mid+1;
        }
        return l;
    }
    
    private int countLess(int[]nums, int target){
        int count = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]<=target){
                count++;
            }
        }
        return count;
    }
}
