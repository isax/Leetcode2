public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>lists = new ArrayList<List<Integer>>();
        if(nums.length==0) return lists;
        
        lists.add(Arrays.asList(nums[0]));
        for(int i = 1; i<nums.length; i++){
            List<List<Integer>> cur = new ArrayList<List<Integer>>();
            for(List<Integer> list: lists){
                for(int j = 0; j<=list.size(); j++){ // note: <= here
                    List<Integer> newList = new ArrayList<Integer>(list);
                    newList.add(j, nums[i]);
                    cur.add(newList);
                }
            }
            lists = cur;
        }
        return lists;
    }
    
}
