public class Solution {
    
    // DFS: https://leetcode.com/discuss/60552/beautiful-java-solution-10-lines
    
    // https://leetcode.com/discuss/60179/java-bfs-solution-o-mn-time
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length==0) return;
        
        Queue<Integer>row = new LinkedList<Integer>();
        Queue<Integer>col = new LinkedList<Integer>();
        
        int r = rooms.length; int c = rooms[0].length;
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(rooms[i][j]==0){
                    row.offer(i); col.offer(j);
                }
            }
        }
                    
        while(!row.isEmpty()){
            int i = row.poll();
            int j = col.poll();
                        
            if(i!=0 && rooms[i-1][j]==Integer.MAX_VALUE){
                rooms[i-1][j] = rooms[i][j]+1;
                row.offer(i-1); col.offer(j);
            }
            
            if(j!=0 && rooms[i][j-1]==Integer.MAX_VALUE){
                rooms[i][j-1] = rooms[i][j]+1;
                row.offer(i); col.offer(j-1);
            }
            
            if(i!=r-1 && rooms[i+1][j]==Integer.MAX_VALUE){
                rooms[i+1][j] = rooms[i][j]+1;
                row.offer(i+1); col.offer(j);
            }
            
            if(j!=c-1 && rooms[i][j+1]==Integer.MAX_VALUE){
                rooms[i][j+1] = rooms[i][j]+1;
                row.offer(i); col.offer(j+1);
            }
        }
    }
}
