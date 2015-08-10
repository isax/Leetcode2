public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        
        if(nums==null||nums.length==0) return res;
        
        int start = nums[0];
        
        for(int i = 1; i<nums.length; i++){
           if(nums[i] != nums[i-1]+1){
               output(start, nums[i-1], res);
               start = nums[i];
           }
        }
        output(start, nums[nums.length-1], res);
        return res;
    }
    
    private void output(int s, int e, List<String> o){
        String res;
        if(s==e) res = s+"";
        else res = s +"->"+e;
        o.add(res);
    }
}
