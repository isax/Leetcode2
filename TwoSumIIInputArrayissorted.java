public class Solution {
    
    // Two pointers
    public int[] twoSumTwoPointers(int[] numbers, int target) {
        int l = 0, r = numbers.length-1;
        int [] res = new int[2];
        while(l<r){
            if(numbers[l]+numbers[r]==target){
                res[0] = l+1; res[1] = r+1;
                return res;
            }else if(numbers[l]+numbers[r]>target){
                r--;
            }else{
                l++;
            }
        }
        return null;
    }
    // Binary Search
    public int[] twoSum(int[] numbers, int target) {
        int [] res = new int[2];
        
        for(int i = 0; i<numbers.length; i++){
            
            int t = target- numbers[i];
            int l = i+1; int r = numbers.length-1;
            
            if(t>numbers[r]) continue;
            
            while(l<=r){
                int mid = l +(r-l)/2;
                if(numbers[mid]==t){
                    res[0] = i+1;
                    res[1] = mid+1;
                    return res;
                }else if(numbers[mid]>t){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }
        }
        return null;
    }
}
