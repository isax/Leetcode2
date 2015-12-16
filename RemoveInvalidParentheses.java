public class Solution {
    
    // https://leetcode.com/discuss/67842/share-my-java-bfs-solution
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        
        queue.offer(s);
        visited.add(s);
        
        boolean found =  false; // mark at which level we found the valid one, no need to continue to deleting
        while(!queue.isEmpty()){
            String cur = queue.poll();
            
            if(isValid(cur)){
                res.add(cur);
                found = true;
            }
            
            if(found) continue;
            
            for(int i = 0; i<cur.length(); i++){
                // we only try to remove left or right paren
                if (cur.charAt(i) != '(' && cur.charAt(i) != ')') continue;
                
                String sub = cur.substring(0, i) + cur.substring(i+1);
                if(!visited.contains(sub)){
                    queue.offer(sub);
                    visited.add(sub);
                }
            }
        }
        return res;
    }
    
    private boolean isValid(String s){
        int lo = 0, ro = 0;
        for(int i = 0; i<s.length(); i++){
           if(s.charAt(i)=='(') lo++;
           else if(s.charAt(i)==')'){
               if(lo==0) ro++;
               else lo--;
           }
        }
        if(lo==0 && ro==0) return true;
        else return false;
    }
    
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
        Set<String> set = new HashSet<String>();
        helper(rmL, rmR, 0, s, 0, new StringBuilder(), set);
        
        return new ArrayList<String>(set);
    }
    
    private void helper(int rmL, int rmR, int count, String s, int cur, StringBuilder sb, Set<String> res){
        if(cur==s.length() && rmL==0 && rmR==0 && count==0){ //&&
            res.add(sb.toString());
            return;
        }
        
        if(cur==s.length() || rmL<0 || rmR<0 || count<0 ) return; 
        
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
