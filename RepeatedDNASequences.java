public class Solution {
    // https://leetcode.com/discuss/25399/clean-java-solution-hashmap-bits-manipulation
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> currentSet = new HashSet<Integer>();
        
        List<String> list = new ArrayList<String>();
        if(s==null || s.length()<10) return list;
        
        char[] map = new char[26];
        //map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        
        for(int i = 0; i<s.length()-9; i++){
            int n = 0;
            for(int j = i; j<i+10; j++){
                n |= map[s.charAt(j)-'A'];
                n <<= 2;
            }
            if(!set.add(n) && currentSet.add(n)){
                list.add(s.substring(i, i+10));
            }
        }
        return list;
    }
    
    public List<String> findRepeatedDnaSequences2(String s) {
        Set<String> set = new HashSet<String>();
        Set<String> res = new HashSet<String>();
        List<String> list = new ArrayList<String>();
        if(s==null || s.length()<10) return list;
        
        for(int i = 0; i<s.length()-9; i++){
            String candidate = s.substring(i, i+10);
            if(!set.add(candidate)){
                res.add(candidate);
            }
        }
        
        list.addAll(res);
        return list;
    }
}
