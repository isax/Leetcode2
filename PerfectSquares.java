public class Solution {
    // DP
    public int numSquares(int n) {
        
        int [] dp = new int[n+1];
        
        for(int i = 1; i<n+1; i++){
            int sqrt = (int)Math.sqrt(i);
            if(sqrt*sqrt==i) dp[i] = 1;
            else {
                int min = Integer.MAX_VALUE;
                for(int j = 1; j <= sqrt; j++ ){
                    min = Math.min(min, 1 + dp[i-j*j]);
                }
                dp[i] = min;
            }
        }
        return dp[n];
    }
    
    // can use for (int i = 1; i*i<=n; i++)
    
    // REVISIT THIS: https://leetcode.com/discuss/58056/summary-of-different-solutions-bfs-static-and-mathematics
    // BFS
    public int numSquares(int n) {
        
        int sqrt = (int)Math.sqrt(n);
        if(sqrt*sqrt==n) return 1;
        
        int [] perfectSquares = new int[sqrt+1];
        int [] count = new int[n+1]; // count[i] = least # of sum(perfect #s) = i 
        
        for(int i = 1; i<=sqrt; i++){
            perfectSquares[i] = i*i;
            count[i*i] = 1;
        }
        
        // bfs
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 1; i<perfectSquares.length; i++){
            queue.offer(perfectSquares[i]);
        }
        int curCount = 1; // since we already pushed a bunch of perfect squars
        
        while(!queue.isEmpty()){
            int curSize = queue.size();
            curCount++;
            
            for(int i = 0; i<curSize; i++){
                int cur = queue.poll();
                
                for(int pp = 1; pp < perfectSquares.length; pp++){
                    int p = perfectSquares[pp];
                    
                    if(cur+p==n){
                        return curCount;
                    }else if(cur+p < n && count[cur+p]==0){
                        count[cur+p] = curCount;
                        queue.offer(cur+p);
                        
                    }else if(cur+p > n){
                        break;
                    }
                }
            }
        }
        return -1;
    }
    
}
