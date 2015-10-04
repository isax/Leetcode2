public class Solution {
    public int uniquePaths(int m, int n) {
        int [] pre = new int [n];
        
        for(int i = 0; i<n; i++){
            pre[i] = 1;
        }
        
        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                pre[j] += pre[j-1];
            }
        }
        return pre[n-1];
    }
}
