public class Solution {
    public List<List<Integer>> generateMy(int numRows) {
       List<List<Integer>> res = new ArrayList<List<Integer>>();
       if(numRows==0) return res;
       
       List<Integer> firstRow = new ArrayList<Integer>();
       firstRow.add(1);
       res.add(firstRow);
       
       for(int i = 1; i<numRows; i++){
           List<Integer> curRow = new ArrayList<Integer>();
           List<Integer> lastRow = res.get(i-1);
           
           curRow.add(1);
           for(int j = 0; j<lastRow.size()-1; j++){
               curRow.add(lastRow.get(j) + lastRow.get(j+1));
           }
           curRow.add(1);
           res.add(curRow);
       }
       return res;
    }
    
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> res = new ArrayList<List<Integer>>();
       if(numRows==0) return res;
       
       for(int i = 0; i<numRows; i++){
           List<Integer> curRow = new ArrayList<Integer>();
           curRow.add(1);
           
           if(i>0){
               List<Integer> lastRow = res.get(i-1);
               for(int j = 0; j<lastRow.size()-1; j++){
                   curRow.add(lastRow.get(j) + lastRow.get(j+1));
               }
               curRow.add(1);
           }
           res.add(curRow);
       }
       return res;
    }
}
