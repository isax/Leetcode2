public class Solution {
    
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<String> list = dfs(s, wordDict, map);
        return list;
    }
    
    private List<String> dfs(String s, Set<String> wordDict,  Map<String, List<String>> map){
        if(map.containsKey(s)){
            return map.get(s);
        }
        
        //if("".equals(s)) return Arrays.asList("");
        
        List<String> list = new ArrayList<String>();
        
        for(int i = 0; i<s.length(); i++){
            String cur = s.substring(i);
            if(wordDict.contains(cur)){
                if(i==0){
                    list.add(cur);
                }else{
                    String prev = s.substring(0, i);
                    List<String> prevList = dfs(prev, wordDict, map);
                    for(String p : prevList){
                        list.add(p + " " + cur);
                    }
                }
            }
        }
        map.put(s, list);
        return list;
    }
    
    
    // Backtracking
    public List<String> wordBreakBacktracking(String s, Set<String> wordDict) {
        List<String> list = new ArrayList<String>();
        helper(s, 0, new StringBuilder(), list, wordDict);
        return list;
    }
    
    private void helper(String s, int start, StringBuilder sb, List<String> list, Set<String> wordDict){
        if(start==s.length()){
            list.add(sb.toString());
        }
        
        for(int i = start+1; i<=s.length(); i++){
            String cur = s.substring(start, i);
            if(wordDict.contains(cur)){
                int len = sb.length();
                if(sb.length()!=0) sb.append(" ");
                sb.append(cur);
                helper(s, i, sb, list, wordDict);
                sb.setLength(len);
            }
        }
    }
}
