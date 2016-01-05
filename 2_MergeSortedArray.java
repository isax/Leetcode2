public class Solution {
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m+n-1;
        if(n==0) return;
        m--; n--;
        
        for(;i>=0; i--){
            if(m>=0 && nums1[m]>=nums2[n]){
                nums1[i] = nums1[m];
                m--;
            }else{
                nums1[i] = nums2[n];
                n--;
            }
            if(n<0) return;
        }
    }
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m+n-1;
        m--; n--;
        
        while(m>=0 && n>=0){
            if(m>=0 && nums1[m]>=nums2[n]){
                nums1[i] = nums1[m];
                m--;
            }else{
                nums1[i] = nums2[n];
                n--;
            }
            i--;
        }
        
        for(;n>=0; n--, i--){
            nums1[i] = nums2[n];
        }
    }
}
