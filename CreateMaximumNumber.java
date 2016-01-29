public class Solution {
    // https://leetcode.com/discuss/75756/share-my-greedy-solution
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int [] res = new int[k];
        for(int i = Math.max(0, k-m); i<=Math.min(k, n); i++){
            int [] candidate = merge(maxArray(nums1, i), maxArray(nums2, k-i), k);
            if (greater(candidate, 0, res, 0)) {
                res = candidate;
            }
        }
        return res;
    }
    
    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++){
            res[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return res;
    }
    
    private boolean greater(int[]nums1, int i, int[]nums2, int j){
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j==nums2.length || i<nums1.length && nums1[i]>nums2[j];
    }
    
    private int[] maxArray(int [] nums, int k){
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i<nums.length; i++){
            while(!stack.isEmpty() && stack.peek()<nums[i] && nums.length-i>k-stack.size()){
                stack.pop();
            }
            if(stack.size()<k) stack.push(nums[i]);
        }
        
        int[] res = new int[k];
        for(int i = k-1; i>=0; i--){
            res[i] = stack.pop();
        }
        return res;
    }

} 
