public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<Character, String>();
        Set<String> set = new HashSet<String>();
        return dfs(pattern, 0, str, 0, map, set);
    }
    
    private boolean dfs(String pattern, int i, String str, int j, Map<Character, String> map, Set<String> set){
        if(i==pattern.length() || j==str.length()){
            return i==pattern.length() && j==str.length();
        }
        
        char ch = pattern.charAt(i);
        if(map.containsKey(ch)){
            String toMatch = map.get(ch);
            if(str.length()-j <toMatch.length()) {
                return false;
            }
            for(int k = 0; k<toMatch.length(); k++){
                if(toMatch.charAt(k)!=str.charAt(j+k)){
                    return false;
                }
            }
            return dfs(pattern, i+1, str, j+toMatch.length(), map, set);
        }else{
            for(int k = j; k<str.length(); k++){
                String curStr = str.substring(j, k+1);
                if(set.contains(curStr)) {
                    continue;
                }else{
                    map.put(ch, curStr);
                    set.add(curStr);
                    if(dfs(pattern, i+1, str, k+1, map, set)){
                        return true;
                    }
                    // reset
                    map.remove(ch); 
                    set.remove(curStr);
                }
            }
            return false;
        }
    }
}
