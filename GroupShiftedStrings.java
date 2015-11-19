public class Solution {

    // https://leetcode.com/discuss/67240/around-13-lines-code-in-java
    // https://leetcode.com/discuss/50358/my-concise-java-solution
    
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        Arrays.sort(strings);
        
        for(int i = 0; i<strings.length; i++){
            if(strings[i].length()==0) continue;
            
            int offset = strings[i].charAt(0)-'a';
            
            String temp = "";
            for(int j = 0; j<strings[i].length(); j++){
                char c = (char) (strings[i].charAt(j)-offset);
                // key += (word.charAt(i) - offset + 26) % 26;
                if(c<'a') c += 26;
                temp += c;
            }
            
            if(!map.containsKey(temp)){
                map.put(temp, new ArrayList<Integer>());
            }
            map.get(temp).add(i);
        }
        
        for(Map.Entry<String,List<Integer>> entry: map.entrySet()){
            List<String> list = new ArrayList<String>();
            for(int i : entry.getValue()){
                list.add(strings[i]);
            }
            res.add(list);
        }
        return res;
    }
}
