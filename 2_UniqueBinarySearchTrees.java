public class Solution {
    public int numTrees(int n) {
        int [] nums = new int[n+1];
        nums[0] = 1;
        
        for(int i = 1; i<=n; i++){
            int count = 0;
            for(int j = 1; j<=i; j++){
                int left = nums[j-1];
                int right = nums[i-j];
                count += left*right;
            }
            nums[i] = count;
        }
        return nums[n];
    }
}
