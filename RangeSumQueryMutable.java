public class NumArray {

    // https://leetcode.com/discuss/70202/17-ms-java-solution-with-segment-tree
    SegmentTreeNode root = null;
    
    public NumArray(int[] nums) {
        root = buildSegmentTree(nums, 0, nums.length-1);
    }
    
    private SegmentTreeNode buildSegmentTree(int[]nums, int start, int end){
        if(start>end){
            return null;
        }else {
            SegmentTreeNode root = new SegmentTreeNode(start, end);
            if(start==end) {
                root.sum = nums[start];
            }else{
                int mid = (start+end)/2;
                root.left = buildSegmentTree(nums, start, mid);
                root.right = buildSegmentTree(nums, mid+1, end);
                root.sum = root.left.sum + root.right.sum;
            }
            return root;
        }
    }

    void update(int i, int val) {
        updateHelper(root, i, val);
    }
    
    private void updateHelper(SegmentTreeNode root, int i, int val){
        if(root.start==root.end){
            root.sum = val;
        }else{
            int mid = (root.start + root.end)/2;
            if(i<=mid){
                updateHelper(root.left, i, val);
            }else{
                updateHelper(root.right, i, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRangeHelper(root, i, j);
    }
    
    private int sumRangeHelper(SegmentTreeNode root, int i, int j){
        if(root.start==i && root.end==j) return root.sum;
        
        int mid = (root.start+root.end)/2;
        if(j<=mid){
            return sumRangeHelper(root.left, i, j);
        }else if(i>mid){
            return sumRangeHelper(root.right, i, j);
        }else{
            return sumRangeHelper(root.left, i, mid) + sumRangeHelper(root.right, mid+1, j);
        }
    }
    
    class SegmentTreeNode{
        int start, end;
        SegmentTreeNode left, right;
        int sum;
        
        SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
            left = null; right = null;
            sum = 0;
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
