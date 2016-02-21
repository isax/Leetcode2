public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> prev = Arrays.asList(0);
        for(int i = 1; i<=n; i++){
            List<Integer> cur = new ArrayList<Integer>(prev);
            int add = 1<<(i-1);
            for(int j = prev.size()-1; j>=0; j--){
                cur.add(add + prev.get(j));
            }
            prev = cur;
        }
        return prev;
    }
}
