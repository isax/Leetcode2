public class Solution {
    // https://leetcode.com/discuss/69572/easiest-java-solution-with-explanations
    // O(NlogN) worst case O(N^2)
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int row = m;
        int col = n;
        
        int [] uf = new int[row*col];
        Arrays.fill(uf, -1);
        
        int count = 0;
        List<Integer> list = new ArrayList<Integer>();
        for(int p = 0; p<positions.length; p++){
            int i = positions[p][0];
            int j = positions[p][1];
            
            int cur = i*col + j;
            uf[i*col + j] = i*col + j;
            count++;
            
            if(i>0 && uf[(i-1)*col + j]!=-1){ // connect
                if(connect(uf, (i-1)*col + j, i*col+j)){
                    count--;
                }
            }
            
            if(j>0 && uf[i*col + j-1]!=-1){ // connect
                if(connect(uf, i*col + j-1, i*col+j)){
                    count--;
                }
            }
            
            if(i<row-1 && uf[(i+1)*col + j]!=-1){ // connect
                if(connect(uf, (i+1)*col + j, i*col+j)){
                    count--;
                }
            }
            
            if(j<col-1 && uf[i*col + j+1]!=-1){ // connect
                if(connect(uf, i*col + j+1, i*col+j)){
                    count--;
                }
            }
            
            list.add(count);
        }
        return list;
    }
    
    private int findRoot(int [] uf, int i){
        while(uf[i]!=i){
            uf[i] = uf[uf[i]];
            i = uf[i];
        }
        return i;
    }
    
    private boolean connect(int[]uf, int i, int j){
        int root1 = findRoot(uf, i);
        int root2 = findRoot(uf, j);
        boolean merge = false;
        if(root1!=root2){
            merge = true;
            uf[root2] = root1; 
        }
        return merge;
    }
}
