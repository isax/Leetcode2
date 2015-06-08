public class Solution {
    public boolean isHappy(int n) {
        if(n==1 || n==7) return true;
        else if(n<10) return false;
        
        int sum = 0;
        while(n>0){
            sum += square(n%10);
            n = n/10;
        }
        
        return isHappy(sum);
    }
    
    public int square(int n){
        return n*n;
    }
}
