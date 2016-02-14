public class Solution {
    // https://leetcode.com/discuss/73721/easiest-20ms-94%25-java-solution

   
    public int strobogrammaticInRange(String low, String high) {
        if(low.length()<=high.length()) return helper(low.length(), high.length(), low, high);
        else return 0;
    }
    
    private int helper(int lower, int upper, String low, String high){
        List<String>[] cache = new List[upper+1];
        cache[0] = Arrays.asList("");
        cache[1] = Arrays.asList("0","1","8");
        
        for(int i = 2; i<=upper; i++){
            cache[i] = new ArrayList<String>();
            for(String prev : cache[i-2]){
                cache[i].add("0"+prev+"0");
                cache[i].add("1"+prev+"1");
                cache[i].add("6"+prev+"9");
                cache[i].add("8"+prev+"8");
                cache[i].add("9"+prev+"6");
            }
        }
        int count = 0;
        for(int i = lower; i<=upper; i++){
            for(String s : cache[i]){
                // WRONG: if(s.compareTo(low)>=0 && s.compareTo(high)<=0){
                if((i!=1 && s.charAt(0)=='0') || s.length()==low.length() && s.compareTo(low)<0 || s.length()==high.length() && s.compareTo(high)>0) continue;
                else count++;
            }
        }
        return count;
    }
    
}
