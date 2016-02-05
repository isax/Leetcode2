public class Solution {
    // http://blog.csdn.net/xudli/article/details/46955257
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> deque = new LinkedList<Integer>();
        int len = nums.length;
        if(len==0) return new int[0];
        
        int [] res = new int[len-k+1];
        for(int i = 0; i<len; i++){
            // should set the max in window i-(k-1) ... i
            while(!deque.isEmpty() && nums[i]>=nums[deque.getLast()]){
                deque.removeLast();
            }
            deque.addLast(i);
            
            if(i-k+1>deque.getFirst()) deque.removeFirst();
            
            if(i-k+1>=0) res[i-k+1] = nums[deque.getFirst()];
        }
        return res;
    }
}
