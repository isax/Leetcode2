public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<String>();
        
        for(int i = 0; i<nums.length; i++){
            if(nums[i]>lower){
                list.add(range(lower, nums[i]-1));
            }
            lower = nums[i] + 1;
        }
        if(lower<=upper) list.add(range(lower, upper)); // CONSIDER EMPTY ARRAY CASE
        return list;
    }
    private String range(int l, int h){
        if(l==h) return "" + l;
        else return l + "->" + h;
    }
}
