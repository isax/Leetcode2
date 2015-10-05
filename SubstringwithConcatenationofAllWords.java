public class Solution {
    // Code Ganker: http://blog.csdn.net/linhuanmars/article/details/20342851
    // Edge case: "wordgoodgoodgoodbestword" ["word","good","best","good"]
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<Integer>();
        if(words.length==0) return list;
        
        int wordLen = words[0].length();
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        HashMap<String, Integer> wd = new HashMap<String, Integer>();
        
        for(String w : words){
            if(!wd.containsKey(w)){
                wd.put(w, 1);
            }else{
                wd.put(w, wd.get(w)+1);
            }
        }
        
        for(int start = 0; start<wordLen; start++){
            hm.clear();
            int count = 0;
            
           for(int left = start, right = start; right+wordLen<=s.length(); right += wordLen){
                String str = s.substring(right, right+wordLen);
                
                if(!wd.containsKey(str)){ // is a valid word
                    left = right+wordLen;
                    hm.clear();
                    count = 0; 
                    continue;
                }
                
                if(!hm.containsKey(str) || hm.get(str)<wd.get(str)) {
                    if(!hm.containsKey(str)) hm.put(str, 1);
                    else hm.put(str, hm.get(str)+1);
                    
                    count++;
                    
                    if(count==words.length){ // one result
                        list.add(left);
                        String leftMostStr = s.substring(left, left+wordLen);
                        
                        hm.put(leftMostStr, hm.get(leftMostStr)-1); // no need to remove it entirely
                        count--;
                        
                        left += wordLen;
                    }
                }else{
                    // remove starting from left, until the old duplicate one is removed
                    while(hm.get(str)>=wd.get(str)){
                        String toRemove = s.substring(left, left+wordLen);
                        
                        hm.put(toRemove, hm.get(toRemove)-1);
                        
                        left += wordLen;
                        count--;
                    }
                    hm.put(str, hm.get(str)+1);
                    count++;
                }
            }
        }
        return list;
    }
}
