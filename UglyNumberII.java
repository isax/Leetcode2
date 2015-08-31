public class Solution {
    // https://leetcode.com/discuss/52716/o-n-java-solution
    public int nthUglyNumber(int n) {
        if(n<=0) return -1;
        
        int [] ugly = new int[n];
        ugly[0] = 1;
        int q2 = 1; int q3 = 1; int q5 = 1;
        int index2 = 0; int index3 = 0; int index5 = 0; // point to the current ugly
        
        for(int i = 1; i<n; i++){
            int cur = Math.min(Math.min(2*ugly[index2], 3*ugly[index3]), 5*ugly[index5]);
            
            if(cur==2*ugly[index2]){
                q2 = cur;
                index2++;
            }
            // can't use else if
            if(cur==3*ugly[index3]){
                q3 = cur;
                index3++;
            }
            if(cur==5*ugly[index5]){
                q5 = cur;
                index5++;
            }
            ugly[i] = cur;
        }
        return ugly[n-1];
        
    }
    
    public int nthUglyNumber2(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 3;
        if(n==4) return 5;
        
        HashSet<Integer> hs = new HashSet<Integer>();
        hs.add(1); hs.add(2); hs.add(3); hs.add(5);
        
        int prev = 5;
        for(int i = 5; i<=n; i++){
            int cur = prev + 1;
            while(true){
                if(cur%2==0 && hs.contains(cur/2) || cur%3==0 && hs.contains(cur/3) || cur%5==0 && hs.contains(cur/5)){
                    hs.add(cur);
                    prev = cur;
                    break;
                }
                cur++;
            }
        }
        return prev;
    }
    
}
