public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> hm = new HashMap<Character, Character>();
        Set<Character> hs = new HashSet<Character>();
        
        for(int i = 0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(hm.containsKey(c2)){
                if(hm.get(c2)!=c1) return false;
            }else{
                if(hs.contains(c1)) return false;
                else{
                    hm.put(c2, c1);
                    hs.add(c1);
                }
            }
        }
        return true;
    }
    
    public boolean isIsomorphic(String s, String t) {
        char[] map = new char[256];
        char[] map2 = new char[256];
        
        for(int i = 0; i<s.length(); i++){
            if(map[s.charAt(i)]==0 && map2[t.charAt(i)]==0){
                map[s.charAt(i)] = t.charAt(i);
                map2[t.charAt(i)] = s.charAt(i);
            }else if(map[s.charAt(i)]!=t.charAt(i) || map2[t.charAt(i)]!=s.charAt(i)){
                return false;
            }
        }
        return true;
    }
    
    public boolean isIsomorphicMine(String s, String t) {
        Set<Character> sSet = new HashSet<Character>();
        Set<Character> tSet = new HashSet<Character>();
        char[] c = new char[256];
        
        for(int i = 0; i<s.length(); i++){
            if(sSet.contains(s.charAt(i))){
                if(t.charAt(i)!=c[s.charAt(i)]) return false;
            }else{
                if(tSet.contains(t.charAt(i))) return false;
                
                sSet.add(s.charAt(i)); tSet.add(t.charAt(i));
                c[s.charAt(i)] = t.charAt(i);
            }
        }
        return true;
    }
}
