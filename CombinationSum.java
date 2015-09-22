public class Solution {
    // DO NOT USE CACHE, THE ORDER MATTERS HERE...
    // http://codeganker.blogspot.com/2014/03/combination-sum-leetcode.html
    public List<List<Integer>> combinationSum(int[] candidates, int target ) {
        Arrays.sort(candidates);
        List<List<Integer>> res = helper(candidates, target,0);
        
        return res;
    }
    
    private List<List<Integer>> helper(int[] candidates, int target, int cur ) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        //HashSet<Integer> hs = new HashSet<Integer>();
        for(int i = cur; i<candidates.length; i++){
            if(i>0 && candidates[i]==candidates[i-1]) continue;
            
            if(candidates[i]>target) continue;
            else {
                //if(hs.contains(candidates[i])) continue;
                
                if(i>0 && candidates[i]==candidates[i-1])
                    continue;
                
                if(candidates[i]==target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(candidates[i]);
                    res.add(list);
                }else{
                    List<List<Integer>> candidateList = helper(candidates, target-candidates[i], i);
                    for(List<Integer>list:candidateList){
                        list.add(0,candidates[i]);
                        res.add(list);
                    }
                }
               //hs.add(candidates[i]);
            }
        }
        return res;
    }
}
