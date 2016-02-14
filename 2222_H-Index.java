public class Solution {
    public int hIndex2(int[] citations) {
        Arrays.sort(citations);
        
        for(int i = 0; i<citations.length; i++){
            if(citations[i]>=citations.length-i) return citations.length-i;
        }
        return 0;
    }
    
    // https://leetcode.com/discuss/56815/o-n-java-solution-using-o-n-space
    // https://leetcode.com/discuss/56041/a-clean-o-n-solution-in-java
    public int hIndex(int[] citations) {
        int N = citations.length;
        int [] count = new int[N+1];
        
        // h can be up to N,
        // all papers has citation of at least N
        for(int c : citations){
            if(c>=N){
                count[N]++;
            }else{
                count[c]++;
            }
        }
        
        int total = 0;
        for(int i = N; i>=0; i--){
            total += count[i];
            if(total>=i){
                return i;
            }
        }
        return 0;
    }
}
