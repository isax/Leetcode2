public class Solution {
    
    public int reverse(int x) {
        if(x==Integer.MIN_VALUE){
            return 0;
        }
        boolean positive = x>0?true:false;
        x = Math.abs(x);
        int res = 0;
        
        while(x>0){
            if(res>(Integer.MAX_VALUE-x%10)/10) return 0; //5/2=2, 3>2
            res = res*10 + x%10; 
            x /= 10;
        }
        return positive?res:-res;
    }
    
    public int reverseMine(int x) {
        if(x==0) return 0;
        boolean positive = x>0?true:false;
        x = Math.abs(x);
        
        long res = 0;
        while(x>0){
            int digit = x%10;
            res = res*10 + digit;
            x /= 10;
        }
        if(positive && res>Integer.MAX_VALUE || !positive && -res<Integer.MIN_VALUE){
            return 0;
        }else{
            return (int)(positive?res:-res);
        }
    }
}
