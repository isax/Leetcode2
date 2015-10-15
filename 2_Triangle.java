public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int [] cache = new int [triangle.size()];
        
        for(int i = triangle.size()-1; i>=0; i--){
            for(int j = 0; j<triangle.get(i).size(); j++){
                if(i==triangle.size()-1) cache[j] = triangle.get(i).get(j);
                else cache[j] = Math.min(cache[j], cache[j+1])+triangle.get(i).get(j);
            }
        }
        
        return cache[0];
    }
    
    // TLE
    public int minimumTotal2(List<List<Integer>> triangle) {
        return helper(triangle, 0, 0);
    }
    
    private int helper(List<List<Integer>> triangle, int level, int i){
        if(level==triangle.size()) return 0;
        
        int sum = triangle.get(level).get(i);
        sum += Math.min(helper(triangle, level+1, i), helper(triangle, level+1, i+1));
        
        return sum;
    }
}
