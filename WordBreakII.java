    // TLE no cache
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        wordBreakHelper(s, wordDict, 0, new StringBuilder(), res);
        return res;
    }
    
    public void wordBreakHelper(String s, Set<String> wordDict, int start, StringBuilder sb, List<String> res){
        if(start==s.length()) {
            res.add(new String(sb));
        }
        
        for(int i = start+1; i<=s.length(); i++){
            String subStr = s.substring(start, i);
            if(wordDict.contains(subStr)){
                StringBuilder sb_new = new StringBuilder(sb);
                if(i!=s.length()){
                    sb_new.append(subStr+" ");
                }else{
                    sb_new.append(subStr);
                }
            }
            wordBreakHelper(s, wordDict, i, sb, res);
        }
    }
    
    // DFS with cache
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        return wordBreakHelper(s, wordDict, 0, map);
    }
    
    public List<String> wordBreakHelper(String s, Set<String> wordDict, int start, Map<Integer, List<String>> map){
        if(start==s.length()) {
            return null;
        }
        if(map.containsKey(start)){
            return map.get(start);
        }
        List<String> res = new ArrayList<String>();
        for(int i = start+1; i<=s.length(); i++){
            String subStr = s.substring(start, i);
            if(wordDict.contains(subStr)){
                List<String> rest = wordBreakHelper(s, wordDict, i, map);
                if(rest==null){
                    StringBuilder sb = new StringBuilder(subStr);
                    res.add(sb.toString());
                }else{
                    for(String str: rest){
                        StringBuilder sb = new StringBuilder(subStr);
                        sb.append(" ");
                        sb.append(str);
                        res.add(sb.toString());
                    }
                }
            }
        }
        map.put(start, res);
        return res;
    }
