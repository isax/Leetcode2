public class Solution {
    public boolean isUgly(int num) {
        if(num<=0) return false;
        
        while(num%2==0){
            num /= 2;
        }
        while(num%3==0){
            num /= 3;
        }
        while(num%5==0){
            num /= 5;
        }
        return num==1;
    }
    
    // nao dong qing qi
    public boolean isUglyBFS(int num) {
        if(num<=0) return false;
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(1);
        
        while(!q.isEmpty()){
            int i = q.poll();
            if(i==num) return true;
            
            if(i*2<=num) q.offer(i*2);
            if(i*3<=num) q.offer(i*3);
            if(i*5<=num) q.offer(i*5);
        }
        return false;
    }
}
