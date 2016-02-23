public class Solution {
    // https://leetcode.com/discuss/72711/using-min-heap-accepted-java-and-python-code
    // >O(nlogk) for large # of duplicates
    // https://leetcode.com/discuss/75061/heap-is-slower-than-array-possible-explanation
    public int nthSuperUglyNumber(int n, int[] primes) {
        int [] res = new int[n];
        res[0] = 1;
        
        Queue<Num> queue = new PriorityQueue<Num>(primes.length, new Comparator<Num>(){
            public int compare(Num n1, Num n2){
                return n1.value - n2.value;
            }
        });
        for(int i = 0; i<primes.length; i++){
            queue.offer(new Num(primes[i], primes[i], 0));
        }
        
        for(int i = 1; i<n; i++){
            res[i] = queue.peek().value;
            
            while(queue.peek().value==res[i]){
                Num duplicate = queue.poll();
                queue.offer(new Num(res[duplicate.curUgly+1]*duplicate.p, duplicate.p, duplicate.curUgly+1));
            }
        }
        return res[n-1];
    }
    
    private class Num{
        int value; // real value
        int p; // p in prime number
        int curUgly; // index of current ugly number 
        
        Num(int value, int p, int curUgly){
            this.value = value;
            this.p = p;
            this.curUgly = curUgly;
        }
    }

    
    public int nthSuperUglyNumberDedup(int n, int[] primes) {
        int [] res = new int[n];
        res[0] = 1;
        int [] cur = new int[primes.length];
        
        for(int i = 1; i<n; i++){
            res[i] = Integer.MAX_VALUE;
            for(int j = 0; j<primes.length; j++){
                if(primes[j] * res[cur[j]] == res[i-1]) {
                    cur[j]++;
                }
                res[i] = Math.min(res[i], primes[j]*res[cur[j]]);
            }
        }
        return res[n-1];
    }
    
    // https://leetcode.com/discuss/72835/108ms-easy-to-understand-java-solution
    public int nthSuperUglyNumber2(int n, int[] primes) {
        int [] res = new int[n];
        res[0] = 1;
        int [] cur = new int[primes.length];
        
        for(int i = 1; i<n; i++){
            res[i] = Integer.MAX_VALUE;
            for(int j = 0; j<primes.length; j++){
                res[i] = Math.min(res[i], primes[j]*res[cur[j]]);
            }
            
            for(int j = 0; j<cur.length; j++){
                if(res[i]==primes[j]*res[cur[j]]){
                    cur[j]++;
                }
            }
        }
        return res[n-1];
    }
    
    public int nthSuperUglyNumberOOM(int n, int[] primes) {
        Queue<Integer> q = new PriorityQueue<Integer>();
        q.offer(1);
        
        int curUgly = 1;
        for(int i = 0; i<n; i++){
            curUgly = q.poll();
            
            while(!q.isEmpty() && curUgly==q.peek()){
                q.poll();
            }
            for(int j = 0; j<primes.length; j++){
                q.offer(primes[j]*curUgly);
            }
        }
        return curUgly;
    }
}
