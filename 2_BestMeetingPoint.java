public class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> xs = new ArrayList<Integer>();
        List<Integer> ys = new ArrayList<Integer>();
        
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j]==1) {
                    xs.add(i);
                    ys.add(j);
                }
            }
        }
        int rowDist = getDistance(xs);
        int colDist = getDistance(ys);
        return rowDist + colDist;
    }
    
    private int getDistance(List<Integer> list){
        Collections.sort(list);
        int l = 0, r = list.size()-1;
        int distance = 0;
        while(l<r){
            distance += list.get(r) - list.get(l);
            l++; r--;
        }
        return distance;
    }
}
