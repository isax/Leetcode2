public class Solution {
    // https://leetcode.com/discuss/79083/share-my-solution
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[]sums = new long[nums.length+1];
        for(int i = 0; i<nums.length; i++){
            sums[i+1] = sums[i] + nums[i];
        }
        return mergeSort(sums, 0, nums.length, lower, upper);
    }
    
    private int mergeSort(long[]sums, int start, int end, int lower, int upper){
        if(end-start==0) return 0;
        
        int mid = (start+end)/2;
        int count = mergeSort(sums, start, mid, lower, upper) + mergeSort(sums, mid+1, end, lower, upper);
        
        long [] cache = new long[end-start+1];
        int j = mid+1, k = mid+1, t = mid+1;
        for(int i = start, n = 0; i<=mid; i++, n++){
            // dont need to reset j or k or t
            // each of them will only traversal the right half once at most
            while (k <= end && sums[k] - sums[i] < lower) k++;
            while (j <= end && sums[j] - sums[i] <= upper) j++;
            while (t <= end && sums[t] < sums[i]) cache[n++] = sums[t++];
            
            cache[n] = sums[i];
            count += j-k;
        }
        System.arraycopy(cache, 0, sums, start, t-start);
        return count;
    }
    
    
    // BruteForce2
    public int countRangeSumBruteForce2(int[] nums, int lower, int upper) {
        long[]sum = new long[nums.length+1];
        for(int i = 0; i<nums.length; i++){
            sum[i+1] = sum[i]+nums[i];
        }
        int count = 0;
        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if(sum[j]-sum[i]>=lower && sum[j]-sum[i]<=upper){
                    count++;
                }
            }
        }
        return count;
    }
    
    public int countRangeSumBruteForce(int[] nums, int lower, int upper) {
        int count = 0;
        for(int i = 0; i<nums.length; i++){
            int sum = 0;
            for(int j = i; j<nums.length; j++){
                sum += nums[j];
                if(sum>=lower && sum<=upper){
                    count++;
                }
            }
        }
        return count;
    }
}
