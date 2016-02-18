public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] cache = new int[triangle.size()];
        
        for(int i = triangle.size()-1; i>=0; i--){
            for(int j = 0; j<triangle.get(i).size(); j++){
                if(i==triangle.size()-1) cache[j] = triangle.get(i).get(j);
                else cache[j] = Math.min(cache[j], cache[j+1]) + triangle.get(i).get(j);
            }
        }
        return cache[0];
    }
    
    public int minimumTotalMine(List<List<Integer>> triangle) {
        if(triangle.isEmpty()||triangle.get(0).isEmpty()) return 0;
        int[] dp = new int[triangle.get(triangle.size()-1).size()];
        dp[0] = triangle.get(0).get(0);
        
        for(int i = 1; i<triangle.size(); i++){
            List<Integer> list = triangle.get(i);
            for(int j = list.size()-1; j>=0; j--){
                if(j==list.size()-1){
                    dp[j] = dp[j-1] + list.get(j);
                }else if(j==0){
                    dp[j] += list.get(j);
                }else{
                    dp[j] = Math.min(dp[j], dp[j-1]) + list.get(j);
                }
            }
        }
        int min = dp[0];
        for(int i = 0; i<dp.length; i++){
            min = Math.min(dp[i], min);
        }
        return min;
    }
}
