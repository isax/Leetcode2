public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        
        for(int i = len-1; i>=0; i--){
            if(digits[i]<9){
                digits[i] += 1;
                return digits;
            }else{
                digits[i] = 0;
            }
        }
        
        int [] res = new int[len+1];
        Arrays.fill(res, 0);
        res[0] = 1;
        return res;
    }
    
    public int[] plusOneMine(int[] digits) {
        int len = digits.length;
        int[]res = new int[len+1];
        
        int add = 1;
        for(int i = len-1; i>=-1; i--){
            int cur = i>=0?digits[i]+add:add;
            res[i+1] = cur%10;
            add = cur/10;
        }
        
        if(res[0]==0){
            int[] ans = new int[len];
            for(int i = 0; i<len; i++){
                ans[i] = res[i+1];
            }
            res = ans;
        }
        return res;
    }
}
