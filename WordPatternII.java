public class Solution {
    
    //https://leetcode.com/discuss/63393/20-lines-java-clean-solution-easy-to-understand
    public boolean wordPatternMatch(String pattern, String str) {
        return helper(pattern, str, new HashMap<Character, String>(),  new HashSet<String>());
    }
    
    private boolean helper(String pattern, String str, Map<Character, String> hm, Set<String> hs){
        /*if(pattern.length()==0 && str.length()==0){
            return true;
        }
        if((pattern.length()==0 && str.length()!=0 )|| (pattern.length()!=0 && str.length()==0)) return false;*/
        if(pattern.length()==0) return str.length()==0; // a good way to check if the two are both empty
        
        char ch = pattern.charAt(0);
        if(hm.containsKey(ch)){
            String matchingStr = hm.get(ch);
            if(str.length()>= matchingStr.length() && str.substring(0, matchingStr.length()).equals(matchingStr)){
                return helper(pattern.substring(1), str.substring(matchingStr.length()), hm, hs);
            }else{
                return false; 
            }
        }else{ // first time seeing this char
            for(int i = 1; i<=str.length(); i++){
                String substr = str.substring(0, i);
                if(!hs.contains(substr)){ // ignore if it was already mapped to another char
                    hm.put(ch, substr);
                    hs.add(substr);
                    if(helper(pattern.substring(1), str.substring(i), hm, hs)) {
                        return true;
                    }else {
                        hm.remove(ch);
                        hs.remove(substr);
                    }
                }
            }
        }
        return false;
    }
}
