public class Solution {
    // http://blog.csdn.net/linhuanmars/article/details/19905515
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if((m+n)%2==1){
            return helper(nums1, 0, m-1, nums2, 0, n-1, (m+n)/2+1);
        }else{
            return (helper(nums1, 0, m-1, nums2, 0, n-1, (m+n)/2) + helper(nums1, 0, m-1, nums2, 0, n-1, (m+n)/2+1))/2.0;
        }
    }
    
    // m should be <= n
    private double helper(int[]nums1, int i, int j, int[] nums2, int p, int q, int k){
        int m = j-i+1;
        int n = q-p+1;
        
        if(m>n){
            return helper(nums2, p, q, nums1, i, j, k);
        }
        if(m==0){
            return nums2[p+k-1];
        }
        if(k==1){ // for [1], [1]
            return Math.min(nums1[i], nums2[p]);
        }
        
        int pos1 = Math.min(k/2,m);  
        int pos2 = k-pos1;  
        
        if(nums1[i+pos1-1]==nums2[p+pos2-1]){
            return nums1[i+pos1-1];
        }else if(nums1[i+pos1-1] < nums2[p+pos2-1]){
            return helper(nums1, i+pos1, j, nums2, p, p+pos2-1, k-pos1);  // throw away pos1 of A from first k
        }else{
            return helper(nums1, i, j+pos1-1, nums2, p+pos2, q, k-pos2); // throw away pos2 of B from first k
        }
    }
}
