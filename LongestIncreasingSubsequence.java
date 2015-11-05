public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int global = 0;
        int [] local = new int[len];
        Arrays.fill(local, 1);
        
        for(int i = 0; i<len; i++){
            for(int j = i-1; j>=0; j--){
                if(nums[j]<nums[i]){
                    local[i] = Math.max(local[i], local[j]+1);
                }
            }
            global = Math.max(global, local[i]);
        }
        return global;
    }
    
    
    // O(nlogn)
    // https://leetcode.com/discuss/67572/o-nlogn-and-o-n-2-java-solutions
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len==0) return 0;
        
        int [] tailTable = new int[len];
        int cur = 0;
        
        for(int i = 0; i<len; i++){
            if(i==0 || nums[i]<tailTable[0]) tailTable[0] = nums[i];
            else if(nums[i]>tailTable[cur])  tailTable[++cur] = nums[i];
            else{
                int index = binarySearch(0, cur, nums[i], tailTable);
                tailTable[index] = nums[i];
            }
        }
        return cur+1;
    }
    
    private int binarySearch(int l, int r, int target, int [] tailTable){
        while(l<=r){
            int mid = l + (r-l)/2;
            if(tailTable[mid]<target) l = mid+1;
            else r = mid-1;
        }
        return l;
    }
}
