public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator==0) return "NaN";/////////////
        if(numerator==0) return "0";
        
        StringBuilder sb = new StringBuilder();
        boolean positive = numerator>0 && denominator>0 || numerator<0 && denominator<0;////////////
        if(!positive){
            sb.append("-");
        }
        long num = Math.abs(new Long(numerator)); //////////
        long deno = Math.abs(new Long(denominator));
        
        sb.append(num/deno);
        if(num%deno==0) return sb.toString();
        num = num%deno;
        sb.append(".");
        
        Map<Long, Integer> hm = new HashMap<Long, Integer>();
        while(num!=0){
            if(hm.containsKey(num)){
                sb.insert(hm.get(num), "(");
                sb.append(")");
                break;
            }else{
                hm.put(num, sb.length());
            }
            
            num *= 10;
            sb.append(num/deno);
            num = num%deno;
        }
        return sb.toString();
    }
}
