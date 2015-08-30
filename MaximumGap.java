public class Solution {
    // https://leetcode.com/discuss/18499/bucket-sort-java-solution-with-explanation-o-time-and-space
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = nums.length;
        
        for(int i = 0; i<len; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        
        int gap = (max-min)/(len-1); //(int)Math.ceil((double)(max - min)/(nums.length - 1)); 
        
        // put into bukets
        int []minValues = new int[len-1];
        int []maxValues = new int[len-1];
        
        for(int i = 0; i<len-1; i++){
            minValues[i] = Integer.MAX_VALUE;
            maxValues[i] = Integer.MIN_VALUE;
        }
        
        for(int i = 0; i<len; i++){
            if(nums[i]==min || nums[i]==max) continue;
            
            int index = (nums[i]-min)/gap;
            minValues[index] = Math.min(nums[i], minValues[index]);
            maxValues[index] = Math.max(nums[i], maxValues[index]);
        }
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        //scan and find the max gap
        for(int i = 0; i<len-1; i++){
            if(minValues[i]==Integer.MAX_VALUE&&maxValues[i]==Integer.MIN_VALUE) {
                // empty bucket
                continue;
            }
            maxGap = Math.max(maxGap, minValues[i]-previous);
            previous = maxValues[i];
        }
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
    }
    
    // Including max and min
    public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = nums.length;
        
        for(int i = 0; i<len; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        
        int gap = (int)Math.ceil((double)(max - min)/(len + 1)); 
        
        // put into bukets
        int []minValues = new int[len+1];
        int []maxValues = new int[len+1];
        
        for(int i = 0; i<len+1; i++){
            minValues[i] = Integer.MAX_VALUE;
            maxValues[i] = Integer.MIN_VALUE;
        }
        
        for(int i = 0; i<len; i++){
            int index = nums[i]==max ? len : (nums[i]-min)/gap;
            minValues[index] = Math.min(nums[i], minValues[index]);
            maxValues[index] = Math.max(nums[i], maxValues[index]);
        }
        
        int maxGap = Integer.MIN_VALUE;
        int previous = maxValues[0];
        
        //scan and find the max gap
        for(int i = 1; i<len+1; i++){
            if(minValues[i]==Integer.MAX_VALUE&&maxValues[i]==Integer.MIN_VALUE) {
                // empty bucket
                continue;
            }
            maxGap = Math.max(maxGap, minValues[i]-previous);
            previous = maxValues[i];
        }
        return maxGap;
    }
}
}
