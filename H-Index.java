public class Solution {
    public int hIndex2(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        for(int i = 0; i<len; i++){
            if(citations[i]>=len-i){
                return len-i;
            }
        }
        return 0;
    }
    
    // https://leetcode.com/discuss/56815/o-n-java-solution-using-o-n-space
    // https://leetcode.com/discuss/56041/a-clean-o-n-solution-in-java
    public int hIndex(int[] citations) {
        int len = citations.length;
        int [] counting = new int[len+1];
        
        for(int i = 0; i<len; i++){
            if(citations[i]>len){
                counting[len]++;
            }else{
                counting[citations[i]]++;
            }
        }
        
        int total = 0;
        for(int i = len; i>=0; i--){
            total += counting[i];
            if(total>=i) return i;
        }
        return 0;
    }
}
