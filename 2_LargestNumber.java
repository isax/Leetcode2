public class Solution {
    //https://leetcode.com/discuss/76126/share-my-fast-java-solution-beat-98-64%25
    //https://leetcode.com/discuss/21587/simple-solution-with-java-o-nlogn-and-no-need-for-biginteger
    public String largestNumber(int[] nums) {
        if(nums.length==0) return "";
        
        String[] strs = new String[nums.length];
        
        for(int i = 0; i<nums.length; i++){
            strs[i] = nums[i] + "";
        }
        
        Arrays.sort(strs, new Comparator<String>(){
           public int compare(String s1, String s2){
               return (s2+s1).compareTo(s1+s2);
           } 
        });
        
        StringBuilder res = new StringBuilder();
        for(String s : strs){
            res.append(s);
        }
        if(res.charAt(0)=='0') return "0";
        return res.toString();
    }
}
