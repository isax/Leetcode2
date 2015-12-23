public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        helper(n, 0, 0, new StringBuilder(), list);
        return list;
    }
    
    private void helper(int n, int left, int right, StringBuilder sb, List<String> list){
        if(sb.length()==n*2){
            list.add(sb.toString());
            return;
        }
        
        if(left>right){ // can add ")"
            sb.append(")");
            helper(n, left, right+1, sb, list);
            sb.setLength(sb.length()-1);
        }
        
        // add "("
        if(left<n){ // can add 
            sb.append("(");
            helper(n, left+1, right, sb, list);
            sb.setLength(sb.length()-1);
        }
    }
}
