public class Solution {
    public int trap(int[] height) {
        
        int left = 0;
        int right = height.length-1;
        
        int total = 0;
        
        while(left<right){
            if(height[left]<height[right]){
                int l = left;
                while(height[left]<=height[l] && left<right){
                    total += height[l]-height[left];
                    left++;
                }
            }else{
                int r = right;
                while(height[right]<=height[r] && left<right){
                    total += height[r]-height[right];
                    right--;
                }
            }
        }
        return total;
    }
    
    // Code Ganker: http://blog.csdn.net/linhuanmars/article/details/20888505
    public int trap2(int[] height) {
        int [] leftMax = new int[height.length];
        int total = 0;
        
        int max = 0;
        for(int i = 0; i<height.length; i++){
            leftMax[i] = max;
            max = Math.max(max, height[i]);
        }
        max = 0;
        for(int i = height.length-1; i>=0; i--){
            if(height[i]<max && height[i]<leftMax[i]){
                total += Math.min(max, leftMax[i]) - height[i];
            }
            max = Math.max(max, height[i]);
        }
        return total;
    }
    
    
    // My weird two pointers alg:
    // for each bar, first -> compute area when right max > left max and they build water for bar
    // then <- compute area when left max > right max and they build water for bar
    public int trapMine(int[] height) {
        if(height.length==0 || height.length==1) return 0;
        
        int left = 0, right = 1;
        int total = 0;
        
        while(right<height.length){
            if(height[left]<=height[right]){
                // compute area
                total += Math.min(height[left], height[right])*(right-left-1);
                for(int i = left+1; i<right; i++){
                    total -= height[i];
                }
                left = right;
                right++;
            }else{
                right++;
            }
        }
        
        left = height.length-2; right = height.length-1;
        while(left>=0){
            if(height[left]>height[right]){
                // compute area
                total += Math.min(height[left], height[right])*(right-left-1);
                for(int i = right-1; i>left; i--){
                    total -= height[i];
                }
                right = left;
                left--;
            }else{
                left--;
            }
        }
        
        return total;
    }
}
