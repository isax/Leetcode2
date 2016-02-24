public class Solution {
    // https://leetcode.com/discuss/60179/java-bfs-solution-o-mn-time
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length==0 || rooms[0].length==0) return;
        int row = rooms.length;
        int col = rooms[0].length;
        
        Queue<Integer> r = new LinkedList<Integer>();
        Queue<Integer> c = new LinkedList<Integer>();
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(rooms[i][j]==0){
                    r.offer(i);
                    c.offer(j);
                }
            }
        }
        
        while(!r.isEmpty()){
            int i = r.poll();
            int j = c.poll();
            
            if(i>0 && rooms[i-1][j]==Integer.MAX_VALUE){
                rooms[i-1][j] = rooms[i][j]+1;
                r.offer(i-1);
                c.offer(j);
            }
            
            if(j>0 && rooms[i][j-1]==Integer.MAX_VALUE){
                rooms[i][j-1] = rooms[i][j]+1;
                r.offer(i); 
                c.offer(j-1);
            }
            
            if(i<row-1 && rooms[i+1][j]==Integer.MAX_VALUE){
                rooms[i+1][j] = rooms[i][j]+1;
                r.offer(i+1); 
                c.offer(j);
            }
            
            if(j<col-1 && rooms[i][j+1]==Integer.MAX_VALUE){
                rooms[i][j+1] = rooms[i][j]+1;
                r.offer(i); 
                c.offer(j+1);
            }
        }
                        
    }
                    
    public void wallsAndGatesMine(int[][] rooms) {
        if(rooms.length==0 || rooms[0].length==0) return;
        int row = rooms.length;
        int col = rooms[0].length;
        
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(rooms[i][j]==0){
                    // bfs
                    Queue<Integer> r = new LinkedList<Integer>();
                    Queue<Integer> c = new LinkedList<Integer>();
                    r.offer(i);
                    c.offer(j);
                    
                    int level = 0;
                    while(!r.isEmpty()){
                        int count = r.size();
                        for(int m = 0; m<count; m++){
                            int curR = r.poll();
                            int curC = c.poll();
                            rooms[curR][curC] = level;
                            
                            if(curR>0 && rooms[curR-1][curC]>level+1){
                                r.offer(curR-1);
                                c.offer(curC);
                            }
                            if(curC>0 && rooms[curR][curC-1]>level+1){
                                r.offer(curR);
                                c.offer(curC-1);
                            }
                            if(curR<row-1 && rooms[curR+1][curC]>level+1){
                                r.offer(curR+1);
                                c.offer(curC);
                            }
                            if(curC<col-1 && rooms[curR][curC+1]>level+1){
                                r.offer(curR);
                                c.offer(curC+1);
                            }
                        }
                        level++;
                    }
                }
            }
        }
    }
}
