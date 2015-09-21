public class Solution {
    // http://bangbingsyb.blogspot.com/2014/11/leetcode-permutation-sequence.html
    public String getPermutation(int n, int k) {
        int [] fac = new int[n];
        fac[0] = 1;
        for(int i = 1; i<n; i++){
            fac[i] = fac[i-1]*i;
        }
        
        LinkedList <Integer> num = new LinkedList<Integer>();
        for(int i = 1; i<=n; i++){
            num.offer(i);
        }
        
        StringBuilder sb = new StringBuilder();
        k--;
        
        for(int i = n; i>=1; i--) {
            int curIndex = k/fac[i-1];
            int cur = num.get(curIndex);
            sb.append(cur+"");
            num.remove(curIndex);
            
            k = k%fac[i-1];
        }
        
        return sb.toString();
    }
    
    public String getPermutationMy(int n, int k) {
        
        LinkedList <Integer> num = new LinkedList<Integer>();
        for(int i = 1; i<=n; i++){
            num.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        k--;
        for(int i = n; i>=1; i--) {
            int factorOfRest = getFactorial(i-1);
            int curIndex = k/factorOfRest;
            int cur = num.get(curIndex);
            sb.append(cur+"");
            num.remove(curIndex);
            
            k = k%factorOfRest;
        }
        
        return sb.toString();
    }
    
    private int getFactorial(int n){
        int res = 1;
        for(int i = n; i>0; i--){
            res *= i;
        }
        return res;
    }
}
