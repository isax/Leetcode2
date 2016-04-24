public class Solution {
    public List<String> summaryRanges(int[] nums) {
        int low = 0;
        
        List<String> list = new ArrayList<String>();
        for(int i = 1; i<=nums.length; i++){
            if(i==nums.length || nums[i]!=nums[i-1]+1){
                String range = createRange(nums[low], nums[i-1]);
                list.add(range);
                low = i;
            }
        }
        return list;
    }
    
    private String createRange(int low, int high){
        if(low==high){
            return low + "";
        }else{
            return low + "->" + high;
        }
    }
}
