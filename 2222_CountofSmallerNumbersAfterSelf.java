public class Solution {
    // BinarySearch
    // https://leetcode.com/discuss/73280/my-simple-ac-java-binary-search-code
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        List<Integer> sorted = new ArrayList<Integer>();
        
        for(int i = nums.length-1; i>=0; i--){
            int pos = findIndex(sorted, nums[i]);
            sorted.add(pos, nums[i]);
            res.add(0, pos);
        }
        return res;
    }
    
    private int findIndex(List<Integer> list, int target){
        int l = 0, r = list.size()-1;
        
        while(l<=r){
            int mid = (l+r)/2;
            if(list.get(mid) >= target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
    
    // https://leetcode.com/discuss/73256/mergesort-solution
    // http://algobox.org/count-of-smaller-numbers-after-self/
    public List<Integer> countSmaller(int[] nums) {
        Tuple[] t = new Tuple[nums.length];
        for (int i = 0; i < nums.length; i++) {
            t[i] = new Tuple(nums[i], i);
        }
        
        int[] smaller = new int[nums.length];
        t = sort(t, smaller);
        
        List<Integer> res = new ArrayList<>();
        for (int i : smaller) {
            res.add(i);
        }
        return res;
    }
    
    private Tuple[] sort(Tuple[] t, int [] smaller){
        if(t.length<=1) return t;
        
        int half = t.length/2;
        Tuple[] left = Arrays.copyOfRange(t, 0, half);
        Tuple[] right = Arrays.copyOfRange(t, half, t.length);
        
        left = sort(left, smaller);
        right = sort(right, smaller);
        
        int i = left.length-1, j = right.length-1;
        for(int n = t.length-1; n>=0; n--){
            if(j<0 || i>=0 && left[i].number>right[j].number){
                t[n] = left[i];
                smaller[left[i].index] += j + 1;
                i--;
            }else{
                t[n] = right[j];
                j--;
            }
        }
        return t;
    }
    
    private class Tuple{
        int number;
        int index;
        
        Tuple(int number, int index){
            this.number = number;
            this.index = index;
        }
    }
}
