public class Solution {
    // https://leetcode.com/discuss/38336/solutions-partition-priority_queue-multiset-respectively
    // https://leetcode.com/discuss/36966/solution-explained
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length-1;
        
        while(left<=right){
            int p = helper(nums, left, right);
            if(p==k-1){
                return nums[p];
            }else if(p<k-1){
                left = p+1;
            }else{
                right = p-1;
            }
        }
        return -1;
    }
    
    private int helper(int[]nums, int left, int right){
        int pivot = nums[left];
        int l = left+1;
        while(l<=right){
            if(nums[l]<pivot && nums[right]>pivot) {
                swap(l++, right--, nums);
            }
            if(nums[l]>=pivot) l++;
            if(nums[right]<=pivot) right--;
        }
        swap(left, right, nums);
        return right;
    }
    
    private void swap(int left, int right, int[]nums){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
    
    // built-in java priority queue 
    // Time: O(n*logk)
    public int findKthLargestMine(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k); // Min heap
        
        for(int n : nums){
            q.offer(n);
            if(q.size()>k){
                q.poll();
            }
        }
        return q.peek();
    }
    public int findKthLargest2(int[] nums, int k) {
        int num = nums.length-k+1;
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(num, Collections.reverseOrder()); // Max heap
        
        for(int n : nums){
            q.offer(n);
            if(q.size()>num){
                q.poll();
            }
        }
        return q.peek();
    }
}
