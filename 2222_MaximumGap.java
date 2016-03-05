public class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length<2) return 0;
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        int diff = (max - min) / (nums.length + 1);
        if(diff==0) diff = 1; // every bucket contains one element
        int[] minBuckets = new int[nums.length+1];
        Arrays.fill(minBuckets, Integer.MAX_VALUE);
        int[] maxBuckets = new int[nums.length+1];
        Arrays.fill(maxBuckets, Integer.MIN_VALUE);
        
        for(int i = 0; i<nums.length; i++){
            int cur = nums[i];
            int bucketIndex = 0;
            
            if(nums[i] >= min + diff*nums.length){
                bucketIndex = nums.length;
            }else{
                bucketIndex = (nums[i] - min)/diff;
            }
            minBuckets[bucketIndex] = Math.min(nums[i], minBuckets[bucketIndex]);
            maxBuckets[bucketIndex] = Math.max(nums[i], maxBuckets[bucketIndex]);
        }
        
        int prevBucketMax = maxBuckets[0];
        int maxGap = 0; // set as 0 to solve [1,1,1] Integer.MIN_VALUE;
        for(int i = 1; i<=nums.length;i++){
            if(minBuckets[i]==Integer.MAX_VALUE && maxBuckets[i]==Integer.MIN_VALUE) continue; // empty bucket
            maxGap = Math.max(minBuckets[i] - prevBucketMax, maxGap);
            prevBucketMax = maxBuckets[i];
        }
        return maxGap;
    }
    
    public int maximumGapMine(int[] nums) {
        if(nums.length<2) return 0;
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        int diff = (max - min) / (nums.length + 1);
        if(diff==0) diff = 1; // every bucket contains one element
        Map<Integer, Integer> minBuckets = new HashMap<Integer, Integer>();
        Map<Integer, Integer> maxBuckets = new HashMap<Integer, Integer>();
        
        for(int i = 0; i<nums.length; i++){
            int cur = nums[i];
            if(nums[i]==min && !minBuckets.containsKey(0)){
                minBuckets.put(0, min);
                maxBuckets.put(0, min);
            } else if(nums[i]!=min){
                int bucketIndex = 0;
                if(nums[i] >= min + diff*nums.length){
                    bucketIndex = nums.length;
                }else{
                    bucketIndex = (nums[i] - min)/diff;
                }
                if(!minBuckets.containsKey(bucketIndex)){
                    minBuckets.put(bucketIndex, nums[i]);
                    maxBuckets.put(bucketIndex, nums[i]);
                }else{
                    minBuckets.put(bucketIndex, Math.min(nums[i], minBuckets.get(bucketIndex)));
                    maxBuckets.put(bucketIndex, Math.max(nums[i], maxBuckets.get(bucketIndex)));
                }
            }
        }
        
        int prevBucketMax = maxBuckets.get(0);
        int curBucketMin = 0;
        int maxGap = maxBuckets.get(0) - minBuckets.get(0);
        for(int i = 1; i<=nums.length;i++){
            if(minBuckets.containsKey(i)){
                curBucketMin = minBuckets.get(i);
                maxGap = Math.max(curBucketMin - prevBucketMax, maxGap);
                prevBucketMax = maxBuckets.get(i);
            }
        }
        return maxGap;
    }
}
