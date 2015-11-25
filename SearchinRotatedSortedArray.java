public class Solution {
    
   // https://leetcode.com/discuss/41134/java-ac-solution-using-once-binary-search
   public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        
        while(l<=r){
            int mid = (l+r)/2;
            
            if(target==nums[mid]) return mid;
            
            if(nums[l]<=nums[mid]){ // left sub incremental, have to add "=" for the case when l==mid
               if(target<nums[mid] && target>=nums[l]){
                   r = mid-1;
               }else{
                   l = mid+1; // not in left sub
               }
            }
            
            if(nums[mid]<=nums[r]){ // right sub incremental
                if(target>nums[mid] && target<=nums[r]){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }
        }
        return -1;
    }
}
