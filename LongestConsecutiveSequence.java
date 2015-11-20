public class Solution {
    // http://blog.csdn.net/linhuanmars/article/details/22964467
    // https://leetcode.com/discuss/60632/simple-fast-java-solution-using-set
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int max = 0;
        
        for(int i : nums) set.add(i);
        
        for(int i : nums){
            if(set.remove(i)){// hasn't been visited
               int sum = 1;
               
               int prev = i;
               while(set.remove(prev-1)){
                   prev--;
               }
               sum += i - prev;
               
               int post = i;
               while(set.remove(post+1)){
                   post++;
               }
               sum += post - i;
               max = Math.max(max, sum);
            }
        }
        return max;
    }
}
