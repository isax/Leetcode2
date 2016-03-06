public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length;
        long [] sums = new long[len+1];
        for(int i = 1; i<=len; i++){
            sums[i]  = sums[i-1] + nums[i-1];
        }
        int[] count = new int[1];
        mergeSort(sums, 0, sums.length-1, count, lower, upper);
        return count[0];
    }
    
    private void mergeSort(long[] sums, int i, int j, int[] count, int lower, int upper){
        if(i==j) return;
        int mid = (i+j)/2;
        mergeSort(sums, i, mid, count, lower, upper);
        mergeSort(sums, mid+1, j, count, lower, upper);
        merge(sums, i, mid, j, count, lower, upper);
    }
    
    // need to find nums[j] - nums[left] >= lower and nums[k] - nums[left] > upper
    private void merge(long[] sums, int start, int mid, int end, int[] count, int lower, int upper){
        long [] copy = new long[end-start+1];
        int t = 0; // to track index in sums
        int j = mid + 1, k = mid + 1;
        int r = mid + 1; // to track current right array for items < nums[i]
        for(int i = start; i <= mid; i++){
            while(j <= end && sums[j] - sums[i] < lower) j++;
            while(k <= end && sums[k] - sums[i] <= upper) k++;
            count[0] +=  k - j;
            while(r <= end && sums[r] <= sums[i]) {
                copy[t++] = sums[r++];
            }
            copy[t++] = sums[i];
        }
        //while(r <= end) {
            //copy[t++] = sums[r++];
        //}
        System.arraycopy(copy, 0, sums, start, r-start);
    }
    
    
    // O(n^2) TLE
    public int countRangeSumTLE(int[] nums, int lower, int upper) {
        int len = nums.length;
        long [] sums = new long[len+1];
        
        for(int i = 1; i<=len; i++){
            sums[i]  = sums[i-1] + nums[i-1];
        }
        
        int count = 0;
        for(int i = 0; i<nums.length; i++){
            for(int j = i; j<nums.length; j++){
                long rangeSum = sums[j+1]-sums[i];
                if(rangeSum>=lower && rangeSum<=upper){
                    count++;
                }
            }
        }
        return count;
    }
}
