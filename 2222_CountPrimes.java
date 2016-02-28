public class Solution {
    
    // http://stackoverflow.com/questions/2582732/time-complexity-of-sieve-of-eratosthenes-algorithm
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for(int i = 2; i<n; i++){
            isPrime[i] = true;
        }
        
        for(int i = 2; i*i<n; i++){
            if(!isPrime[i]) continue;
            
            for(int j = i*i; j<n; j += i){
                isPrime[j] = false;
            }
        }
        
        int count = 0;
        for(int i = 2; i<n; i++){
            if(isPrime[i]) count++;
        }
        return count;
    }
    
    // 
    public int countPrimes2(int n) {
        int count = 0;
        for(int i = 1; i<=n; i++){
            if(isPrime(i)) count++;
        }
        return count;
    }
    
    private boolean isPrime(int n){
        // Loop's ending condition is i * i <= num instead of i <= sqrt(num)
        // to avoid repeatedly calling an expensive function sqrt().
        for(int i = 2; i*i<=n; i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
