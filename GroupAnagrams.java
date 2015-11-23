public class Solution {
    // refactor a little
    public List<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs);
        
        HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
        
        for(int i = 0; i<strs.length; i++){
            char[] ca = strs[i].toCharArray();
            Arrays.sort(ca);
            String sortedStr = new String(ca);
            if(!hm.containsKey(sortedStr)){
                hm.put(sortedStr, new ArrayList<String>());
            }
            hm.get(sortedStr).add(strs[i]);
        }
        
        return new ArrayList<List<String>>(hm.values());
    }
    
    public List<List<String>> groupAnagramsMine(String[] strs) {
        Arrays.sort(strs);
        
        HashMap<String, List<Integer>> hm = new HashMap<String, List<Integer>>();
        
        for(int i = 0; i<strs.length; i++){
            char[] ca = strs[i].toCharArray();
            Arrays.sort(ca);
            String sortedStr = new String(ca);
            if(!hm.containsKey(sortedStr)){
                hm.put(sortedStr, new ArrayList<Integer>());
            }
            hm.get(sortedStr).add(i);
        }
        
        List<List<String>> res = new ArrayList<List<String>>();
        for(List<Integer> value: hm.values()){
            List<String> list = new ArrayList<String>();
            for(int i : value){
                list.add(strs[i]);
            }
            res.add(list);
        }
        return res;
    }
}
