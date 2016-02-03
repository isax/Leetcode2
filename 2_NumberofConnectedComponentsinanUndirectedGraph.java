public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] uf = new int[n];
        
        for(int i = 0; i<n; i++){
            uf[i] = i;
        }
        int[] count = new int[1];
        count[0] = n;
        for(int i = 0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            
            connect(a,b,uf, count);
        }
        return count[0];
    }
    
    private void connect(int a, int b, int[]uf, int [] count){
        int p = findRoot(a, uf);
        int q = findRoot(b, uf);
        
        if(p!=q){
            count[0]--;
            uf[p] = q;
        }
    }
    
    private int findRoot(int a, int[]uf){
        while(uf[a]!=a){
            uf[a] = uf[uf[a]];
            a = uf[a];
        }
        return a;
    }
    
}
