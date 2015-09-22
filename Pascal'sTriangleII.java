public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        
        for(int i = 1; i<=rowIndex; i++){
            for(int j = 0; j<i-1; j++){
                res.set(j, res.get(j) + res.get(j+1));
            }
            res.add(0,1);
        }
        return res;
    }
}
