public class Solution {
    
    // https://leetcode.com/discuss/65336/14ms-java-solution
    // we can omit the sort by ......
    public int minTotalDistance(int[][] grid) {
        List<Integer> row = new ArrayList<Integer>();
        List<Integer> col = new ArrayList<Integer>();
        
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        
        return getMin(row) + getMin(col);
    }
    
    private int getMin(List<Integer> list){
        Collections.sort(list);
        
        int l = 0, r = list.size()-1;
        int res = 0;
        while(l<r){
            res += list.get(r--) - list.get(l++);
        }
        return res;
    }
}
