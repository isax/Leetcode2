public class Solution {
    public int candy(int[] ratings) {
        
        int [] res = new int[ratings.length];
        Arrays.fill(res, 1);
        
        for(int i = 0; i<ratings.length-1; i++){
            if(ratings[i]<ratings[i+1]) res[i+1] = res[i] + 1;
            else if(ratings[i]==ratings[i+1]) res[i+1] = 1;
        }
        for(int i = ratings.length-1; i>0; i--){
            if(ratings[i-1]>ratings[i]) res[i-1] = Math.max(res[i-1], res[i]+1);
        }
        
        int count = 0;
        for(int c : res){
            count += c;
        }
        return count;
    }
}
