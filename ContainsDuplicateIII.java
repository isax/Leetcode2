public class Solution {
    // https://leetcode.com/discuss/38206/ac-o-n-solution-in-java-using-buckets-with-explanation
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        
        Map<Long, Long> hm = new HashMap<Long, Long>();
        
        for(int i = 0; i<nums.length; i++){
            long num = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = num/((long)t+1); // in case t == Integer.MAX_VALUE, overflow
            
            if(hm.containsKey(bucket) ||
            ( hm.containsKey(bucket-1) && num - hm.get(bucket-1)<=t) ||
            (hm.containsKey(bucket+1) && hm.get(bucket+1) - num <=t)){
                return true;
            }
            
            if(i >= k){
                long bucketToRemove = ((long)nums[i-k]-Integer.MIN_VALUE)/((long)t+1);
                hm.remove(bucketToRemove);
            }
            hm.put(bucket, num);
        }
        return false;
    }
    
    // https://leetcode.com/discuss/38146/java-solution-with-treeset
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        
        for(int i = 0; i<nums.length; i++){
            if(i>k) set.remove(nums[i-k-1]);
            
            if(set.floor(nums[i])!=null && set.floor(nums[i])>= nums[i]-t || set.ceiling(nums[i])!=null && set.ceiling(nums[i])<=nums[i]+t) return true;
            
            set.add(nums[i]);
        }
        return false;
    }
}
