public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        
        if(nums.length==0) return res;
        
        int start = 0;
        
        for(int i = 1; i<nums.length; i++){
            if(nums[i]-nums[i-1]!=1){
                printResult(nums, start, i-1, res);
                start = i;
            }
        }
        printResult(nums, start, nums.length-1, res);
        return res;
    }
    
    private void printResult(int[]nums, int start, int end, List<String> res){
        if(start==end) {
            res.add(nums[start]+"");
            return;
        }
        String s = nums[start] + "->" + nums[end];
        res.add(s);
    }
}
