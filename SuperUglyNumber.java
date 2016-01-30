public class Solution {
    // https://leetcode.com/discuss/81411/java-three-methods-23ms-58ms-with-heap-performance-explained
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        PriorityQueue<Num> pq = new PriorityQueue<>();
        
        for (int i = 0; i < primes.length; i++) {
            pq.add(new Num(primes[i], 1, primes[i]));
        }
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            ugly[i] = pq.peek().val;
            while (pq.peek().val == ugly[i]) {
                Num nxt = pq.poll();
                pq.add(new Num(nxt.p * ugly[nxt.idx], nxt.idx + 1, nxt.p));
            }
        }
        return ugly[n - 1];
    }
    
    private class Num implements Comparable<Num> {
        int val;
        int idx; // index of current ugly number
        int p;
        public Num(int val, int idx, int p) {
            this.val = val;
            this.idx = idx;
            this.p = p;
        }
        
        @Override
        public int comparetTo(Num that) {
            return this.val - that.val;
        }
    }
    
    public int nthSuperUglyNumber2(int n, int[] primes) {
        int [] ugly = new int[n];
        int [] cur = new int[primes.length];
        int [] val = new int[primes.length];
        Arrays.fill(val, 1);
        
        ugly[0] = 1;
        for(int i = 1; i<n; i++){
            ugly[i] = Integer.MAX_VALUE;
            for(int j = 0; j<primes.length; j++){
                if(val[j]==ugly[i-1]) val[j] = ugly[cur[j]++]*primes[j];
                ugly[i] = Math.min(ugly[i], val[j]);
            }
        }
        return ugly[n-1];
    }
    
    public int nthSuperUglyNumberWithDuplication(int n, int[] primes) {
        int [] ugly = new int[n];
        int [] cur = new int[primes.length];
        
        ugly[0] = 1;
        for(int i = 1; i<n; i++){
            ugly[i] = Integer.MAX_VALUE;
            for(int j = 0; j<primes.length; j++){
                ugly[i] = Math.min(ugly[i], primes[j]*ugly[cur[j]]);
            }
            
            // skip duplicate
            for(int j = 0; j<primes.length; j++){
                if(primes[j]*ugly[cur[j]]==ugly[i]) {
                    cur[j]++;
                }
            }
        }
        return ugly[n-1];
    }
}
