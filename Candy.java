public class Solution {
    public int candy(int[] ratings) {
        
        int increasingMaxLen = 1;
        int tempIncreasingLen = 1;
        
        int [] res = new int[ratings.length];
        
        for(int i = 0; i<res.length;i++){
            res[i]  = 1;
        }
        
        for(int i = 0; i<ratings.length-1; i++){
            if(ratings[i]<ratings[i+1]){
                res[i+1] = res[i] + 1;
            }else if (ratings[i]==ratings[i+1]){
                res[i+1] = 1;
            } 
        }
        
        for(int i = ratings.length-1; i>0; i--){
            if(ratings[i]<ratings[i-1]){
                if(res[i-1]<res[i]+1){
                    res[i-1] = res[i] + 1;
                }
            }
        }
        
        int sum = 0;
        
        for(int i = 0; i<res.length;i++){
            sum  += res[i];
        }
        
        return sum;
    }
}
