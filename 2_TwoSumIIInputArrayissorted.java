public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int [] res = new int[2];
        int l = 0, r = numbers.length-1;
        
        while(l<r){
            
            int sum = numbers[l] + numbers[r];
            
            if(sum==target){
                res[0] = l+1; res[1] = r+1;
                return res;
            }else if(sum>target){
                r--;
            }else{
                l++;
            }
        }
        return res; //
    }
    
    
    
    public int[] twoSumBS(int[] numbers, int target) {
        int [] res = new int[2];
        for(int i = 0; i<numbers.length; i++){
            if(target-numbers[i]<numbers[i]) continue;
            int other = bs(numbers, target-numbers[i], i+1);
            if(other!=-1){
                res[0] = i+1; res[1] = other+1;
                return res;
            }
        }
        return res; //
    }
    
    private int bs(int[]nums, int target, int s){
        if(s==nums.length) return -1;
        
        int e = nums.length-1;
        while(s<=e){
            int mid = (s+e)/2;
            if(target==nums[mid]) return mid;
            else if(target>nums[mid]) s = mid + 1;
            else e = mid - 1;
        }
        return -1;
    }
}
