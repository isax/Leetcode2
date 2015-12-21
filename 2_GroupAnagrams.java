public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs);
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(int i = 0; i<strs.length; i++){
            char [] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String ordered = new String(charArray);
            
            if(!map.containsKey(ordered)){
                map.put(ordered, new ArrayList<String>());
            }
            map.get(ordered).add(strs[i]);
        }
        
        List<List<String>> list = new ArrayList<List<String>>(map.values());
        
        return list;
    }
}
