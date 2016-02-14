public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> hm = new HashMap<String, List<String>>();
        Arrays.sort(strings);///////////
        
        for(int i = 0; i<strings.length; i++){
            String str = strings[i];
            if(str.length()==0) continue;
            
            StringBuilder diff = new StringBuilder();
            int offset = str.charAt(0)-'a';
            for(int j = 0; j<str.length(); j++){
                char ch = (char)(str.charAt(j) - offset);
                if(ch<'a') ch += 26;
                diff.append(ch);
            }
            
            String key = diff.toString();
            if(!hm.containsKey(key)){
                hm.put(key, new ArrayList<String>());
            }
            hm.get(key).add(str);
        }
        
        List<List<String>> res = new ArrayList<List<String>>(hm.values());
        return res;
    }
}
