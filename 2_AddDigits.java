public class Solution {
    public int addDigits2(int num) {
        return (num-1)%9+1;
    }
    
    public int addDigits(int num) {
        while(num/10!=0){
            int newNum = 0;
            while(num!=0){
                newNum += num%10;
                num /= 10;
            }
            num = newNum;
        }
        return num;
    }
}
