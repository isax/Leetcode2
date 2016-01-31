public class Solution {
    // https://leetcode.com/discuss/18731/accepted-cpp-solution-with-explainations
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        if(denominator==0) return "NaN";
        
        StringBuilder sb = new StringBuilder();
        boolean positive = numerator>0 && denominator>0 || numerator<0 && denominator<0;
        if(!positive){
            sb.append("-");
        }
        
        long n = Math.abs(new Long(numerator));
        long d = Math.abs(new Long(denominator)); // need long for abs(Integer.MIN_VALUE);
        sb.append(n/d);
        
        long reminder = n%d;
        
        if(reminder==0){
            return sb.toString();
        }else{
            sb.append(".");
        }
        
        Map<Long, Integer> hm = new HashMap<Long, Integer>();
        while(reminder>0){
            if(hm.containsKey(reminder)){
                sb.insert(hm.get(reminder),"(");
                sb.append(")");
                break;
            }
            
            hm.put(reminder, sb.length());
            reminder *= 10;
            sb.append(reminder/d);
            reminder %= d;
        }
        return sb.toString();
    }
}
