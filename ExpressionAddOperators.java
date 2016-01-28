public class Solution {
    // https://leetcode.com/discuss/75308/java-simple-solution-beats-96-56%25
    // https://leetcode.com/discuss/58614/java-standard-backtrace-ac-solutoin-short-and-clear
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        helper(num, 0, 0, 0, target, sb, res);
        return res;
    }
    
    private void helper(String num, int cur, long prev, long multi, int target, StringBuilder sb, List<String> list){
        if(cur==num.length()){
            if(prev==target){
                list.add(sb.toString());
            }
            return;
        }
        
        for(int i = cur; i<num.length(); i++){
            if(num.charAt(cur)=='0' && i!=cur) break;
            
            long number = Long.parseLong(num.substring(cur, i+1));
            int len = sb.length();
            
            if(cur==0){
                helper(num, i+1, number, number, target, sb.append(number), list);
                sb.setLength(len);
            }else{
                helper(num, i+1, prev+number, number, target, sb.append("+").append(number), list);
                sb.setLength(len);
                helper(num, i+1, prev-number, -number, target, sb.append("-").append(number), list);
                sb.setLength(len);
                helper(num, i+1, prev - multi + multi*number, multi*number, target, sb.append("*").append(number), list);
                sb.setLength(len);
            }
        }
        
        
    }
}
