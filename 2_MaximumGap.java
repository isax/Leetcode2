public class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length==0) return 0;
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int k = (int)Math.ceil((double)(max-min)/(nums.length+1)); // gap
        if(k==0) return 0;
        
        int numOfBuckets = nums.length + 1;
        
        int [] maxes = new int[numOfBuckets];
        Arrays.fill(maxes, Integer.MIN_VALUE);
        int [] mins = new int[numOfBuckets];
        Arrays.fill(mins, Integer.MAX_VALUE);
        
        for(int i = 0; i<nums.length; i++){
            int index = nums[i]==max? nums.length:(nums[i]-min)/k; // need to check if it's max, as [3, 4, 9, 2] - [2, 4), [4, 6), [6, 8), [8,9). Need to do sth special for 9.
            maxes[index] = Math.max(maxes[index], nums[i]);
            mins[index] = Math.min(mins[index], nums[i]);
        }
        
        int maxGap = maxes[0] - mins[0];
        int prevMax = maxes[0];
        for(int i = 1; i<numOfBuckets; i++){
            if(mins[i]==Integer.MAX_VALUE) continue;
            maxGap = Math.max(maxGap, mins[i]-prevMax);
            prevMax = maxes[i];
        }
        return maxGap;
    }
}
