public class Solution {
    // https://leetcode.com/discuss/61514/understood-solution-space-without-modifying-explanation
    public int findDuplicate2(int[] nums) {
        int fast = nums[nums[0]], slow = nums[0];
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        
        fast = 0;
        while(slow!=fast){ // slow index == fast index
        // num[duplicate] = y, nums[y] = z, nums[z] = duplicate
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
    
    // O(nlogn)
    // https://leetcode.com/discuss/60830/solutions-explanation-space-without-changing-input-array
    public int findDuplicate(int[] nums) {
        int l = 1, r = nums.length;
        
        while(l<r){
            int mid = (l+r)/2;
            
            int count = countLess(nums, mid);
            if(count>mid) r = mid;
            else l = mid+1;
        }
        return l;
    }
    
    private int countLess(int[] nums, int target){
    int result=0;
    for(int i=0; i<nums.length; i++)
        if(nums[i]<=target) result++;
    return result;
  }
}
