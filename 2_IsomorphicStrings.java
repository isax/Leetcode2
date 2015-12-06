public class Solution {
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
