public class Solution {
    // http://blog.csdn.net/linhuanmars/article/details/20024907
    public int divide(int dividend, int divisor) {
        if(divisor==0) return Integer.MAX_VALUE;
        int res = 0;
        
        boolean isNeg = false;
        //boolean isNeg = (dividend^divisor)>>>31 == 1; //>>> keeps the sign bit
        // That is the unsigned right bit shift operator. The difference between this and the signed right bit shift operator, is that the unsigned right bit shift operator (>>>) fills with zeroes from the left, and the signed right bit shift operator (>>) fills with the sign bit, thus preserving the sign of the numerical value when shifted.
        // http://stackoverflow.com/questions/1822350/what-is-the-javascript-operator-and-how-do-you-use-it/1822769#1822769
        if(dividend<0) isNeg = !isNeg;
        if(divisor<0) isNeg = !isNeg;
        
        if(dividend==Integer.MIN_VALUE){
            if(divisor == -1) {  
                return Integer.MAX_VALUE;  
            }
            dividend += Math.abs(divisor); 
            
            res++;
        }
        if(divisor==Integer.MIN_VALUE){
            return res; 
        }
        
        divisor = Math.abs(divisor);
        dividend = Math.abs(dividend);
        
        int digit = 0;
        while(divisor <= (dividend>>1)){
            divisor <<= 1;
            digit++;
        }
        
        while(digit>=0){
            if(dividend>=divisor){
                res += 1<<digit;
                dividend -= divisor;
            }
            divisor >>= 1;
            digit--;
        }
        return isNeg?-res:res;
    }
}
