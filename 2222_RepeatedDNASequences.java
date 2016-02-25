public class Solution {
    // https://leetcode.com/discuss/25399/clean-java-solution-hashmap-bits-manipulation
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> res = new HashSet<Integer>();
        
        int[] map = new int[26];
        map['C'-'A'] = 1;
        map['G'-'A'] = 2;
        map['T'-'A'] = 3;
        
        List<String> list = new ArrayList<String>();
        for(int i = 0; i<s.length()-9; i++){
            //String candidate = s.substring(i, i+10);
            int key = 0;
            for(int j = i; j<i+10; j++){
                key <<= 2;
                key |= map[s.charAt(j)-'A'];
            }
            if(!set.add(key) && res.add(key)){
                list.add(s.substring(i, i+10));
            }
        }
        return list;
    }
    
    public List<String> findRepeatedDnaSequences2(String s) {
        Set<String> set = new HashSet<String>();
        Set<String> res = new HashSet<String>();
        
        for(int i = 0; i<s.length()-9; i++){
            String candidate = s.substring(i, i+10);
            if(!set.add(candidate)){
                res.add(candidate);
            }
        }
        return new ArrayList<String>(res);
    }
}
