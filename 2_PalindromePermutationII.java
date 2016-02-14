public class Solution {
    public List<String> generatePalindromes(String s) {
        List<Character> candidates = new ArrayList<Character>();
        Set<Character> set = new HashSet<Character>();
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!set.add(ch)){
                set.remove(ch);
                candidates.add(ch);
            }
        }
        if(set.size()>1) return new ArrayList<String>();
        
        boolean[]visited = new boolean[candidates.size()];
        Collections.sort(candidates); ////////// dont forget
        
        String mid = "";
        if(set.size()==1) {
            for(char c : set){
                mid = c + "";
            }
        }
        List<String> res = new ArrayList<String>();
        helper(candidates, visited, new StringBuilder(), res, mid);
        
        return res;
    }
    
    private void helper(List<Character> candidates, boolean[]visited, StringBuilder sb, List<String> res, String mid){
        if(sb.length()==candidates.size()){
            res.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();/////////////////
            return;
        }
        
        for(int i = 0; i<candidates.size(); i++){
            if(i>0 && candidates.get(i)==candidates.get(i-1) && !visited[i-1]) continue; 
            if(visited[i]) continue;
            
            visited[i] = true;
            sb.append(candidates.get(i));
            helper(candidates, visited, sb, res, mid);
            sb.setLength(sb.length()-1);
            visited[i] = false;
        }
    }
    
}
