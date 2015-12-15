public class Solution {
    // https://leetcode.com/discuss/67842/share-my-java-bfs-solution BFS
    
    // https://leetcode.com/discuss/72208/easiest-9ms-java-solution
    public List<String> removeInvalidParentheses(String s) {
        int rmL = 0, rmR = 0;
        
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                rmL++;
            }else if(s.charAt(i)==')'){
                if(rmL==0) rmR++;
                else rmL--;
            }
        }
        //if(rmL>0 && rmR>0) return new ArrayList<String>(); ")(" , ")()("
        
        Set<String> set = new HashSet<String>();
        helper(rmL, rmR, 0, s, 0, new StringBuilder(), set);
        
        return new ArrayList<String>(set);
    }
    
    private void helper(int rmL, int rmR, int count, String s, int cur, StringBuilder sb, Set<String> res){
        if(cur==s.length() && rmL==0 && rmR==0 && count==0){ 
            res.add(sb.toString());
            return;
        }
        
        if(cur==s.length() || rmL<0 || rmR<0 || count<0 ) return; // count<0 invalid
        
        char ch = s.charAt(cur);
        if(ch=='(' ){
            // remove it, ignore
            helper(rmL-1, rmR, count, s, cur+1, sb, res);
            sb.append(ch);
            // keep it
            helper(rmL, rmR, count+1, s, cur+1, sb, res);
        }else if(ch==')'){
            // remove it
            helper(rmL, rmR-1, count, s, cur+1, sb, res);
            sb.append(ch);
            // keep it
            helper(rmL, rmR, count-1, s, cur+1, sb, res);
        }else{
            sb.append(ch);
            helper(rmL, rmR, count, s, cur+1, sb, res);
        }
        
        sb.setLength(sb.length()-1);
    }
}
