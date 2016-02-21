public class Solution {

    // http://blog.csdn.net/linhuanmars/article/details/19905515
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if(len%2==1){
            return helper(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, len/2+1);
        }else{
            return (helper(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, len/2) + helper(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, len/2+1)) / 2.0;
        }
    }
    
    private int helper(int[]nums1, int i, int j, int[]nums2, int m, int n, int k){
        int a = j-i+1;
        int b = n-m+1;
        
        if(a==0) return nums2[m+k-1];
        if(a>b) return helper(nums2, m, n, nums1, i, j, k);
        if(k==1) return Math.min(nums1[i], nums2[m]);
        
        int c1 = Math.min(k/2, j-i+1);
        int c2 = k - c1;
        
        if(nums1[i+c1-1]==nums2[m+c2-1]){
            return nums1[i+c1-1];
        }else if(nums1[i+c1-1]<nums2[m+c2-1]){
            return helper(nums1, i+c1, j, nums2, m, m+c2-1, k-c1);
            //return helper(nums1, i+c1, j, nums2, m, n, k-c1);
        }else{
            return helper(nums1, i, j+c1-1, nums2, m+c2, n, k-c2);
            //return helper(nums1, i, j, nums2, m+c2, n, k-c2);
        }
    }
}
