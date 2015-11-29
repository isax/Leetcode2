public class Solution {
    
    // https://leetcode.com/discuss/53626/ac-java-solution-with-explanation
    public List<String> generatePalindromes(String s) {
        List<Character> candidates = new ArrayList<Character>();
        
        HashSet<Character> hs = new HashSet<Character>();
        
        for(char ch : s.toCharArray()){
             if(hs.contains(ch)) {
                hs.remove(ch);
                candidates.add(ch);
             }
             else hs.add(ch);
         }
        if(hs.size()>1) return new ArrayList<String>();
        
        List<String> results = new ArrayList<String>();
        
        String mid = "";
        if(hs.size()==1){
            for(char c : hs){
                mid = c + "";
            }
        }
        boolean [] used = new boolean[candidates.size()];
        Collections.sort(candidates);
        helper(candidates, used, new StringBuilder(), results, mid);
        
        return results;
    }
    
    private void helper(List<Character> candidates, boolean[] used, StringBuilder str, List<String> results, String mid){
        if(str.length()==candidates.size()) {
            results.add(str.toString() + mid + str.reverse().toString());
            str.reverse(); ///!!!!!
            return;
        }
        
        for(int i = 0; i<candidates.size(); i++){
            if(i>0 && candidates.get(i)==candidates.get(i-1) && !used[i-1]) continue;
            
            if(!used[i]){
                used[i] = true;
                str.append(candidates.get(i));
                helper(candidates, used, str, results, mid);
                str.setLength(str.length()-1);
                used[i]=false;
            }
        }
    }
}
