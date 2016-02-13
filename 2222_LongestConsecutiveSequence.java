public class Solution {
    // http://blog.csdn.net/linhuanmars/article/details/22964467
    // https://leetcode.com/discuss/60632/simple-fast-java-solution-using-set
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i : nums){
            set.add(i);
        }
        
        int max = 0;
        for(int i : nums){
            if(set.remove(i)){
                int cur = 1;
                int left = i-1;
                while(set.remove(left--)){
                    cur++;
                }
                
                int right = i+1;
                while(set.remove(right++)){
                    cur++;
                }
                
                max = Math.max(cur, max);
            }
        }
        return max;
    }
}
