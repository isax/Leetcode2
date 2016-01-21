public class Solution {
    
    // BinarySearch
    // https://leetcode.com/discuss/73280/my-simple-ac-java-binary-search-code
    public List<Integer> countSmaller(int[] nums) {
        
        List<Integer> sorted = new ArrayList<Integer>();
        int[] smaller = new int[nums.length];
        
        for(int i = nums.length-1; i>=0; i--){
            int index = findIndex(sorted, nums[i]);
            smaller[i] = index;
            sorted.add(index, nums[i]);
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i : smaller) {
            res.add(i);
        }
        return res;
    }
    
    private int findIndex(List<Integer> sorted, int target){
        int l = 0, r = sorted.size()-1;
        
        while(l<=r){
            int mid = (l+r)/2;
            if(sorted.get(mid)<target){
                l = mid+1;
            }else{// [1,2,2,3] -> target: 2
                r = mid-1;
            }
        }
        return l;
    }
    
    // https://leetcode.com/discuss/73256/mergesort-solution
    // http://algobox.org/count-of-smaller-numbers-after-self/
    public List<Integer> countSmallerMergeSort(int[] nums) {
        Tuple[] t = new Tuple[nums.length];
        for (int i = 0; i < nums.length; i++) {
            t[i] = new Tuple(nums[i], i);
        }
        
        int[] smaller = new int[nums.length];
        t = sort2(t, smaller);
        
        List<Integer> res = new ArrayList<>();
        for (int i : smaller) {
            res.add(i);
        }
        return res;
    }
    
    // a little improvement
    private Tuple[] sort2(Tuple[]t, int[]res){
        if(t.length<=1) return t;
        
        int half = t.length/2;
        Tuple[] left = Arrays.copyOfRange(t, 0, half);
        Tuple[] right = Arrays.copyOfRange(t, half, t.length);
            
        left = sort2(left, res);
        right = sort2(right, res);
            
        int i = left.length-1, j = right.length-1;
        
        for(int n = t.length-1; n>=0; n--){
            if(j<0 || i>=0 && left[i].number>right[j].number){
                res[left[i].index] += j+1; // HERE
                t[n] = left[i--];
            }else{
                t[n] = right[j--];
            }
        }
        return t;
    }
    
    private Tuple[] sort(Tuple[]t, int[]res){
        if(t.length<=1) return t;
        
        int half = t.length/2;
        Tuple[] left = Arrays.copyOfRange(t, 0, half);
        Tuple[] right = Arrays.copyOfRange(t, half, t.length);
            
        left = sort(left, res);
        right = sort(right, res);
            
        int i = 0, j = 0;
            
        while(i<left.length || j<right.length){
            if(j==right.length || i<left.length && left[i].number<=right[j].number){
                t[i+j] = left[i];
                res[left[i].index] += j;
                i++;
            }else{
                t[i+j] = right[j];
                j++;
            }
        }
        return t;
    }
    
    private class Tuple{
        public int number;
        public int index;
        
        public Tuple(int number, int index){
            this.number = number;
            this.index = index;
        }
    }
}
