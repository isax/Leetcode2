public class Solution {
    if(height.length==0) return 0;
        int l = 0, r = height.length-1;
        
        int leftMax = height[l], rightMax = height[r];
        int sum = 0;
        while(l<r){
            if(leftMax<rightMax){
                l++;
                sum += Math.max(0, leftMax - height[l]);
                leftMax = Math.max(leftMax, height[l]);
            }else{
                r--;
                sum +=  Math.max(0, rightMax - height[r]);
                rightMax = Math.max(rightMax, height[r]);
            }
        }
        return sum;
    
    
    public int trap(int[] height) {
        int l = 0, r = height.length-1;
        
        int sum = 0;
        while(l<r){
            if(height[l]<height[r]){
                int left = l;
                while(height[l]<=height[left] && l<r){
                    sum += height[left]-height[l++];
                }
            }else{
                int right = r;
                while(height[r]<=height[right] && l<r){
                    sum += height[right]-height[r--];
                }
            }
        }
        return sum;
        
    }
    
    // Code Ganker: http://blog.csdn.net/linhuanmars/article/details/20888505
    public int trap2(int[] height) {
        int[]container = new int[height.length];
        
        for(int i = 1; i<height.length; i++){
            container[i] = Math.max(container[i-1],height[i-1]);
        }
        int sum = 0;
        for(int i = height.length-1; i>=0; i--){
            int left = container[i];
            container[i] = i==height.length-1?0:Math.max(container[i+1],height[i+1]);
            if(height[i]<container[i] && height[i]<left) sum += Math.min(container[i], left)-height[i];
        }
        return sum;
        
    }
    
    public int trapMine(int[] height) {
        int l = 0, r = 1;
        
        int sum = 0;
        while(r<height.length){
            if(height[l]>height[r]){
                r++;
            }else{
                // l move to right
                int low = height[l];
                for(l = l+1; l<r; l++){
                    sum += low - height[l];
                }
                r++;
            }
        }
        l = height.length-2;
        r = height.length-1;
        while(l>=0){
            if(height[l]<=height[r]){
                l--;
            }else{
                // r move to left
                int low = height[r];
                for(r = r-1; r>l; r--){
                    sum += low - height[r];
                }
                l--;
            }
        }
        return sum;
    }
}
