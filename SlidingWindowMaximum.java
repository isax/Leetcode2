public class Solution {
    // http://blog.csdn.net/xudli/article/details/46955257
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> deque = new LinkedList<Integer>();
        if(nums.length==0) return new int[0];
        
        int[] res = new int[nums.length-k+1];
        
        for(int i = 0; i<nums.length; i++){
            while(!deque.isEmpty() && nums[deque.getLast()]<nums[i]){ // or <=, both work
                deque.removeLast();
            }
            
            deque.addLast(i);
            
            if(deque.getFirst()<i-k+1){
                deque.removeFirst();
            }
            
            if(i>=k-1) res[i-k+1] = nums[deque.getFirst()];
        }
        return res;
    }
}
