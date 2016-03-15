public class Solution {
    // 315
    public List<String> removeInvalidParentheses(String s) {
        int minValidPair = getMinValidPairCount(s);
        Set<String> set = new HashSet<String>();
        helper(s.toCharArray(), 0, 0, 0, minValidPair, new StringBuilder(), set);
        return new ArrayList<String>(set);
    }
    //////////////deduppppppppppp
    private void helper(char[] chs, int lc, int rc, int i, int minValidPair, StringBuilder sb, Set<String>set){
        if(i==chs.length){ // ())aaaaa ->  || lc==rc && lc==minValidPair){
            if(lc==rc && lc==minValidPair){
                set.add(sb.toString());
            }
            return;
        }
        
        char ch = chs[i];
        int len = sb.length();
        if(ch!='(' && ch!=')'){
            sb.append(ch);
            helper(chs, lc, rc, i+1, minValidPair, sb, set);
            //sb.setLength(sb.length()-1);
        }else{
            // ignore
            helper(chs, lc, rc, i+1, minValidPair, sb, set);
            
            if(ch=='(' && lc<minValidPair){
                sb.append(ch);
                helper(chs, lc+1, rc, i+1, minValidPair, sb, set);
                //sb.setLength(sb.length()-1);
            }
            
            if(ch==')' && rc<minValidPair && lc>rc){
                sb.append(ch);
                helper(chs, lc, rc+1, i+1, minValidPair, sb, set);
                //sb.setLength(sb.length()-1);
            }
        }
        
        sb.setLength(len);
    }
    private int getMinValidPairCount(String s){
        char [] chs = s.toCharArray();
        int lc = 0, count = 0;
        for(int i = 0; i<chs.length; i++){
            if(chs[i]!='(' && chs[i]!=')') continue;
            
            if(chs[i]=='('){
                lc++;
            }else{
                if(lc!=0){
                    lc--;
                    count++;
                }
            }
        }
        return count;
    }
    
    
    // https://leetcode.com/discuss/67842/share-my-java-bfs-solution
    // BFS O(2^n*n)
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> q = new LinkedList<String>();
        q.offer(s);
        
        Set<String> visited = new HashSet<String>();
        boolean found = false;
        List<String> res = new ArrayList<String>();
        
        while(!q.isEmpty()){
            String cur = q.poll();
            visited.add(cur);
            
            if(isValid(cur)){
                found = true;
                res.add(cur);
            }
            if(found) continue; // stop at this level
            for(int i = 0; i<cur.length(); i++){
                if(cur.charAt(i)!=')'&& cur.charAt(i)!='(') continue;
                String sub = cur.substring(0, i) + cur.substring(i+1);
                if(visited.add(sub)) {
                    q.offer(sub);
                }
            }
        }
        return res;
    }
    
    private boolean isValid(String s){
        int left = 0, right = 0;
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='('){
                left++;
            }else if(ch==')'){
                if(left>0) left--;
                else right++;
            }
        }
        return left==0 && right==0;
    }
    
    
    
    public List<String> removeInvalidParenthesesDFS(String s) {
        int leftRemove = 0, rightRemove = 0;
        char[] chs = s.toCharArray();
        int len = chs.length;
        for(int i = 0; i<len; i++){
            if(chs[i]=='(') {
                leftRemove++;
            }else if(chs[i]==')'){
                if(leftRemove==0){
                    rightRemove++;
                }else{
                    leftRemove--;
                }
            }
        }
        Set<String>list = new HashSet<String>(); ///////////////////////DEDUP
        dfs(0, chs, 0, 0, leftRemove, rightRemove, new StringBuilder(), list);
        return new ArrayList<String>(list);
    }
    
    private void dfs(int i, char[] chs, int lc, int rc, int leftRemove, int rightRemove, StringBuilder sb, Set<String>list){
        if(rc>lc) return;
        if(i==chs.length){
           if(leftRemove==0 && rightRemove==0){
               list.add(sb.toString());
           } 
           return;
        }
        
        char ch = chs[i];
        // not to remove
        sb.append(ch);
        if(ch=='(') dfs(i+1, chs, lc+1, rc, leftRemove, rightRemove, sb, list);
        else if(ch==')') dfs(i+1, chs, lc, rc+1, leftRemove, rightRemove, sb, list);
        else dfs(i+1, chs, lc, rc, leftRemove, rightRemove, sb, list);
        sb.setLength(sb.length()-1);
        
        if(ch=='(' && leftRemove>0){
            dfs(i+1, chs, lc, rc, leftRemove-1, rightRemove, sb, list);
        }
        if(ch==')' && rightRemove>0){
            dfs(i+1, chs, lc, rc, leftRemove, rightRemove-1, sb, list);
        }
    }
    
}
