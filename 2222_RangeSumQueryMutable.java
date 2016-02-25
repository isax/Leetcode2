public class NumArray {
    SegmentTreeNode root;
    
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length-1);
    }
    
    private SegmentTreeNode buildTree(int[]nums, int start, int end){
        if(start>end) return null;
        
        if(start==end) return new SegmentTreeNode(start, end, nums[start]);
        int mid = (start+end)/2;
        SegmentTreeNode left = buildTree(nums, start, mid);
        SegmentTreeNode right = buildTree(nums, mid+1, end);
        SegmentTreeNode root = new SegmentTreeNode(start, end, left.sum+right.sum);
        root.left = left;
        root.right = right;
        return root;
    }

    void update(int i, int val) {
        updateHelper(root, i, val);
    }
    
    private void updateHelper(SegmentTreeNode node, int i, int newVal){
        if(node.start==node.end){
            node.sum = newVal;
        }else{
            int mid = (node.start+node.end)/2;
            if(i>mid){
                updateHelper(node.right, i, newVal);
            }else{
                updateHelper(node.left, i, newVal);
            }
            node.sum = node.right.sum + node.left.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRangeHelper(root, i, j);
    }
    
    private int sumRangeHelper(SegmentTreeNode node, int i , int j){
        if(node.start==i && node.end==j) return node.sum;
        
        int mid = (node.start+node.end)/2;
        if(mid>=j){
            return sumRangeHelper(node.left, i, j);
        }else if(mid<i){
            return sumRangeHelper(node.right, i, j);
        }else{
            return sumRangeHelper(node.left, i, mid) + sumRangeHelper(node.right, mid+1, j);
        }
    }
    
    private class SegmentTreeNode{
        int start, end;
        int sum;
        SegmentTreeNode left, right;
        
        SegmentTreeNode(int start, int end, int sum){
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
