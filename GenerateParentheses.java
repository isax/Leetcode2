public class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder s = new StringBuilder();
        List<String>list = new ArrayList<String>();
        helper(n, n, n, s, list);
        return list;
    }
    
    private void helper(int n, int left, int right, StringBuilder s, List<String>list){
        if(left>right){
            return;
        }
        if(left==0 && right==0) {
            String str = s.toString();
            list.add(str);
            return;
        }
        
        if(left>0){ // push (
            s = s.append("(");
            helper(n, left-1, right, s, list);
            s.deleteCharAt(s.length()-1);
        }
        
        if(right>0){
            s = s.append(")");
            helper(n, left, right-1, s, list);
            s.deleteCharAt(s.length()-1);
        }
    }
}
