public class Solution {
    // O(k*(len1 + len2 + k^2) k^2 is worst case and ideally should be k.
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int [] max = null;
        for(int len1 = Math.max(0, k - nums2.length); len1 <= Math.min(k, nums1.length); len1++){//////////////////
            int len2 = k - len1;
            //if(nums2.length < len2) continue;
            
            int[] candidate = merge(maxSub(nums1, len1), maxSub(nums2, len2));
            if(max==null || compare(candidate, 0, max, 0) < 0){
                max = candidate;
            }
        }
        return max;
    }
    
    private int compare(int [] nums1, int[] nums2){
        int len = nums1.length;
        for(int i = 0; i<len; i++){
            if(nums1[i]<nums2[i]){
                return -1;
            }else if(nums1[i]>nums2[i]){
                return 1;
            }
        }
        return 0;
    }
    
    private int[] merge(int[] nums1, int[] nums2){
        int len1 = nums1.length, len2 = nums2.length;
        int [] res = new int[len1 + len2];
        for(int i = 0, j = 0, t = 0; t<len1+len2; t++){
            if(compare(nums1, i, nums2, j)<0){
                res[t] = nums1[i++];
            }else{
                res[t] = nums2[j++];
            }
            /*
            if(j==len2 || (i<len1 && nums1[i]>nums2[j])){/////////////////
                res[t] = nums1[i++];
            }else if(i==len1 || (j<len2 && nums1[i]<nums2[j])){
                res[t] = nums2[j++];
            }else{ // nums1[i] == nums2[j]
                int m = i, n = j;
                while(m < len1 && n < len2 && nums1[m]==nums2[n]){
                    m++; n++;
                }
                if(n==len2 || (m < len1 && nums1[m]>nums2[n])){
                    res[t] = nums1[i++];
                }else{
                    res[t] = nums2[j++];
                }
            }*/
        }
        return res;
    }
    
    private int compare(int[] nums1, int i, int[] nums2, int j){
        while(i<nums1.length && j<nums2.length && nums1[i]==nums2[j]){
            i++; j++;
        }
        return j==nums2.length || (i<nums1.length && nums1[i]>nums2[j])?-1:1;
    }
    
    private int[] maxSub(int[] nums, int len){
        Stack<Integer> stack = new Stack<Integer>();///////////////
        
        for(int i = 0; i<nums.length; i++){
            while(!stack.isEmpty() && nums[i]>stack.peek() && nums.length - i + stack.size() > len){
                stack.pop();
            }
            if(stack.size() < len) stack.push(nums[i]); /////////////
        }
        
        int [] res = new int[len];
        for(int i = len-1; i>=0; i--){
            res[i] = stack.pop();
        }
        return res;
    }
    
}
