public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int [] c = new int[n];
        
        for(int i = 0; i<n; i++){
            if(i!=0 && ratings[i]>ratings[i-1]){
                c[i] = c[i-1] + 1;
            }else{
                c[i] = 1;
            }
        }
        
        int count = 0;
        for(int i = n-1; i>=0; i--){
            if(i!=n-1 && ratings[i]>ratings[i+1]){
                c[i] = Math.max(c[i], c[i+1] + 1);
            }
            count += c[i];
        }
        return count;
    }
}
