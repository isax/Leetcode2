public class NumArray {
    // https://leetcode.com/discuss/69723/i-really-want-to-know-why-this-is-a-dp-problem
    // DP has 2 attributes - Overlapping subproblems and Memoization. 
    // If you notice, when you compute the presum(N), you can use presum (N-1) and simply add N to it - this is overlapping subproblem.
    // If you stored all the presums upto N-1 in a data structure so that you don't have to recompute, then that's memoization.

/*
    int [] sum;
    public NumArray(int[] nums) {
        sum = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            int prev = i==0?0:sum[i-1];
            sum[i] = prev + nums[i]; 
        }
    }

    public int sumRange(int i, int j) {
        return sum[j] - (i!=0?sum[i-1]:0);
    }*/
    
    int [] sum;
    public NumArray(int[] nums) {
        sum = new int[nums.length+1];
        for(int i = 1; i<=nums.length; i++){
            sum[i] = sum[i-1] + nums[i-1]; 
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
