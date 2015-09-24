public class Solution {
     // TODO: https://leetcode.com/discuss/12235/java-solution-recursive-no-global-variants
    
    //Reference: http://codeganker.blogspot.com/2014/03/permutations-leetcode.html
    
    public List<List<Integer>> permuteCodeGanker(int[] nums) {
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        helper(nums, new boolean[nums.length], new ArrayList<Integer>(), res);
        return res;
        
    }
    
    private void helper(int[]nums, boolean []used, List<Integer> list, List<List<Integer>> res){
        if(list.size()==nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i<nums.length; i++){
            if(!used[i]){
                used[i] = true;
                list.add(nums[i]);
                helper(nums, used, list, res);
                list.remove(list.size()-1);
                used[i]  = false;
            }
        }
    }
    
    // DP
    public List<List<Integer>> permuteDP(int[] nums) {
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        
        for(int i =0; i<nums.length; i++){
            if(res.isEmpty()) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(nums[i]);
                res.add(list);
            } else{
                List<List<Integer>> curRes = new ArrayList<List<Integer>>();
                for(List<Integer>list: res){
                    for(int pos = 0; pos<=i; pos++){
                        List<Integer> newList = new ArrayList<Integer>(list);
                        newList.add(pos, nums[i]);
                        curRes.add(newList);
                    }
                }
                res.clear();
                res.addAll(curRes);
            }
        }
        return res;
    }
}
