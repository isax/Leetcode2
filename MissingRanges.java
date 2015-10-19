public class Solution {
    // https://leetcode.com/discuss/29206/my-concise-java-accepted-solution
    // http://blog.csdn.net/yangliuy/article/details/46502541
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        int pre = lower-1;
        
        for(int i = 0; i<=nums.length; i++){
            int cur = i==nums.length?upper+1:nums[i];
            
            if(pre+2==cur){
                construct(pre+1, pre+1, res);
            }else if(pre+2<cur){
                construct(pre+1, cur-1, res);
            }
            pre = cur;
        }
        return res;
    }
    private void construct(int lower, int upper, List<String> res){
         if(lower>upper) return;
         else if(lower==upper) res.add(lower+"");
         else res.add(lower+ "->"+ upper);
    }
    
    // Mine
    private static class Pair{
        private int low;
        private int high;
        
        public Pair(int low, int high){
            this.low = low;
            this.high = high;
        }
        
        public int getLow(){
            return low;
        }
        
        public int getHigh(){
            return high;
        }
    }
    public List<String> findMissingRangesMine(int[] nums, int lower, int upper) {
        List<Pair> list = new ArrayList<Pair>();
        list.add(new Pair(lower, upper));
        
        int curRange = 0;
        for(int i = 0; i<nums.length; i++){
            int low = list.get(curRange).getLow();
            int up = list.get(curRange).getHigh();
            
            if(nums[i]<low || nums[i]>up) continue; // 3, 3 || 99, 99
            else{
                list.remove(curRange);
                
                Pair pair1 = new Pair(low, nums[i]-1);
                Pair pair2 = new Pair(nums[i]+1, up);
                
                list.add(pair1);
                list.add(pair2);
                curRange++;
            }
        }
        
        List<String> res = new ArrayList<String>();
        for(Pair p: list){
            int low = p.getLow();
            int high = p.getHigh();
            String str = constructRange(low, high);
            if(!str.equals("")) res.add(str);
        }
        return res;
    }
    
    private String constructRange(int i, int j){
        if(i>j) return "";
        else if(i==j) return i+"";
        else return i+ "->"+ j;
    }
}
