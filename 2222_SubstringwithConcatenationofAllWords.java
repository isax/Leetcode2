public class Solution {
    // Code Ganker: http://blog.csdn.net/linhuanmars/article/details/20342851
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> dictionary = new HashMap<String, Integer>();
        for(String str : words){
            if(!dictionary.containsKey(str)){
                dictionary.put(str, 1);
            }else{
                dictionary.put(str, dictionary.get(str)+1);
            }
        }
        
        int len = words[0].length();
        int count = words.length;
        List<Integer> list = new ArrayList<Integer>();
        
        for(int start = 0; start<len; start++){
            int curCount = 0; 
            Map<String, Integer> hm = new HashMap<String, Integer>();
            
            for(int l = start, r = start; r+len<=s.length(); r += len){
                String cur = s.substring(r, r+len);
                if(!dictionary.containsKey(cur)){
                    hm.clear();
                    curCount = 0;
                    l = r + len;
                    continue;
                }
                
                if(!hm.containsKey(cur) || hm.get(cur)<dictionary.get(cur)){ 
                    curCount++;
                    if(!hm.containsKey(cur)){
                        hm.put(cur, 1);
                    }else{
                        hm.put(cur, hm.get(cur)+1);
                    }
                    
                    if(count==curCount){
                        list.add(l);
                        
                        String toRemove = s.substring(l, l+len);
                        hm.put(toRemove, hm.get(toRemove)-1);
                        curCount--;
                        l += len;
                    }
                }else{
                    /////////////IMPORTANT////////////
                    while(hm.get(cur)==dictionary.get(cur)){
                        String toRemove = s.substring(l, l+len);
                        hm.put(toRemove, hm.get(toRemove)-1);
                        curCount--;
                        l += len;
                    }
                    hm.put(cur, hm.get(cur)+1);
                    curCount++;
                }
            }
        }
        return list;
    }
}
