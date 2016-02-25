public class Solution {
    public String getPermutation(int n, int k) {
        int [] factorial = new int[n+1];
        factorial[0] = 1;
        LinkedList <Integer> num = new LinkedList<Integer>();
        for(int i = 1; i<=n; i++){
            factorial[i] = factorial[i-1]*i;
            num.add(i);
        }
        
        StringBuilder sb = new StringBuilder();
        k--;////////////////////////////
        
        for(int i = n-1; i>=0; i--){
            int curRank = k/factorial[i];
            sb.append(num.get(curRank));
            num.remove(curRank);
            k = k%factorial[i];
        }
        return sb.toString();
    }
}
