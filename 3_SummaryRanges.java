public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        
        int low = 0;
        for(int i = 1; i<=nums.length; i++){
            if(i==nums.length || nums[i]!=nums[i-1]+1){
                String range = createRange(nums, low, i-1);
                list.add(range);
                low = i; 
            }
        }
        return list;
    }
    
    public List<String> summaryRangesLonger(int[] nums) {
        List<String> list = new ArrayList<String>();
        
        int low = 0, high = 0;
        for(int i = 1; i<=nums.length; i++){
            if(i!=nums.length && nums[i]==nums[i-1]+1){
                high = i;
            }else{
                String range = createRange(nums, low, high);
                list.add(range);
                low = i; high = i;
            }
        }
        return list;
    }
    
    private String createRange(int[] nums, int low, int high){
        if(low==high){
            return nums[low]+"";
        }else{
            return nums[low]+"->"+nums[high];
        }
    }
}
