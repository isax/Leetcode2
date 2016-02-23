public class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        
        Queue<Integer> q2 = new LinkedList<Integer>();
        q2.offer(2);
        Queue<Integer> q3 = new LinkedList<Integer>();
        q3.offer(3);
        Queue<Integer> q5 = new LinkedList<Integer>();
        q5.offer(5);
        
        int curUgly = 1;
        for(int count = 1; count<n; count++){
            curUgly = Math.min(q2.peek(), Math.min(q3.peek(), q5.peek()));
            
            if(q2.peek()==curUgly){
                q2.poll();
            }
            if(q3.peek()==curUgly){
                q3.poll();
            }
            if(q5.peek()==curUgly){
                q5.poll();
            }
            
            q2.offer(curUgly*2);
            q3.offer(curUgly*3);
            q5.offer(curUgly*5);
        }
        return curUgly;
    }
    
    public int nthUglyNumberMine(int n) {
        if(n==1) return 1;
        
        Queue<Integer> q2 = new LinkedList<Integer>();
        q2.offer(2);
        Queue<Integer> q3 = new LinkedList<Integer>();
        q3.offer(3);
        Queue<Integer> q5 = new LinkedList<Integer>();
        q5.offer(5);
        
        int count = 1;
        int prev = 0;
        while(count<n){
            int cur = 0;
            if(q2.peek()<=q3.peek() && q2.peek()<=q5.peek()){
                cur = q2.poll();
            }else if(q3.peek()<=q2.peek() && q3.peek()<=q5.peek()){
                cur = q3.poll();
            }else{
                cur = q5.poll();
            }
            if(cur==prev){
                continue;
            }else{
                q2.offer(cur*2);
                q3.offer(cur*3);
                q5.offer(cur*5);
                count++;
                prev = cur;
            }
        }
        return prev;
    }
}
