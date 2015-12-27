public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows==0) return res;
        
        List<Integer> list = Arrays.asList(1); res.add(list);
        if(numRows==1) return res;
        
        for(int i = 1; i<numRows; i++){
            List<Integer> lastRow = res.get(i-1);
            List<Integer> curRow = new ArrayList<Integer>();
            
            curRow.add(1);
            for(int j = 0; j<lastRow.size()-1; j++){
                curRow.add(lastRow.get(j) + lastRow.get(j+1));
            }
            curRow.add(1);
            res.add(curRow);
        }
        return res;
    }
}
