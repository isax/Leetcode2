public class Solution {
    
    // Iterative:
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        lists.add(new ArrayList<Integer>());
        
        for(int i = 0; i<nums.length; i++){
            int curCount = lists.size();
            for(int n = 0; n<curCount; n++){ // if n<lists.size() it will fall into loop...as size is increasing...
                List<Integer> newList = new ArrayList(lists.get(n));
                newList.add(nums[i]);
                lists.add(newList);
            }      
        }
        return lists;
    }
    
    // Code Ganker: http://blog.csdn.net/linhuanmars/article/details/24286377
    public List<List<Integer>> subsetsCG(int[] nums) {
        Arrays.sort(nums);
        return helperCG(nums, nums.length-1);
    }
    
    private List<List<Integer>> helperCG(int [] nums, int i){
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(i==-1) {
           lists.add(new ArrayList<Integer>());
           return lists;
        }
        
        List<List<Integer>> lastLists = helperCG(nums, i-1);
        lists.addAll(lastLists);
        for(List<Integer>list : lastLists){
            List<Integer> newlist = new ArrayList(list);
            newlist.add(nums[i]);
            lists.add(newlist);
        }
        return lists;
    }
    
    // backtracking: once i have backtracking in mind, i am not able to think like my old way...
    public List<List<Integer>> subsetsBackTracking(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        helper(nums, -1, list, lists);
        lists.add(new ArrayList<Integer>());
        return lists;
    }
    
    private void helper(int[]nums, int cur, List<Integer>list, List<List<Integer>>lists){
        for(int i = cur+1; i<nums.length; i++){
            list.add(nums[i]);
            lists.add(new ArrayList(list));
            helper(nums, i, list, lists);
            list.remove(list.size()-1);
        }
    }
}
