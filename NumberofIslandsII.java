public class Solution {
    // https://leetcode.com/discuss/69572/easiest-java-solution-with-explanations
    // O(NlogN) worst case O(N^2)
    int[][] dirs = {{-1,0} ,{1,0}, {0,-1}, {0,1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] uf = new int[m*n];
        Arrays.fill(uf, -1);
        
        List<Integer> list = new ArrayList<Integer>();
        int count = 0;
        for(int [] p : positions){
            int row = p[0];
            int col = p[1];
            
            int root = row*n + col;
            uf[root] = root;
            count++;
            
            for(int[]dir: dirs){
                int x = row+dir[0];
                int y = col+dir[1];
                int i = x*n+y;
                
                if(x < 0 || x >= m || y < 0 || y >= n || uf[i] == -1) continue;
                
                int rootOfNeighbor = findIsland(uf, i);
                if(root!=rootOfNeighbor){
                    uf[root] = rootOfNeighbor;
                    root = rootOfNeighbor;
                    count--;
                }
            }
            list.add(count);
        }
        return list;
    }
    
    // http://www.geeksforgeeks.org/union-find-algorithm-set-2-union-by-rank/
    private int findIsland(int [] uf, int i){
        while(i!=uf[i]){
            uf[i] = uf[uf[i]]; // path compression
            i = uf[i];
        }
        return i;
    }
}
