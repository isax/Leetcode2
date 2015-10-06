public class Solution {
    // code ganker: http://blog.csdn.net/linhuanmars/article/details/21145429
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        
        int max = 0;
        
        while(l<r){
            max = Math.max(max, (r-l)*Math.min(height[r],height[l]));
            
            if(height[r]>=height[l]) l++;
            else r--;
        }
        return max;
    }
}
