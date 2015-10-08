public class Solution {
    // Code Ganker: http://blog.csdn.net/linhuanmars/article/details/20434115
    public void nextPermutation(int[] nums) {
        if(nums.length==0 || nums.length==1) return;
        
        int i = nums.length-2;
        while(i>=0 && nums[i+1]<=nums[i]){ // need the =, [5, 1, 1], equal also means there is no space to increase the right part any more.. just like 1,[6,5,4,3,2,1],   6,4,[5,1,1,1,1]
            i--;
        }
        
        if(i==-1){ // 6,5,4,3,2,1
            reverse(nums, 0);
            return;
        }
        
        // find the one that > nums[i] in the decreasing right part
        int nextMin = i+1;
        while(nextMin<nums.length && nums[i]<nums[nextMin]){
            nextMin++;
        }
        nextMin--;
        /*
        for(int j = i+1; j<nums.length; j++){
            if(nums[j]>nums[i]){
                if(nums[j]<nums[nextMin]) nextMin = j;
            }
        }*/
        
        int temp = nums[i];
        nums[i] = nums[nextMin];
        nums[nextMin] = temp;
        
        reverse(nums, i+1);
    }
    
    private void reverse(int[]nums, int s){
        if(s>=nums.length) return;
        
        int l = s;
        int r = nums.length-1;
        
        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++; r--;
        }
    }
    
}
