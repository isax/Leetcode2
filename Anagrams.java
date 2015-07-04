public class Solution {
    public List<String> anagrams(String[] strs) {
        java.util.Hashtable <String, Integer> ht = new java.util.Hashtable<String, Integer>();
        
        List<String> resultList = new ArrayList<String>();
        
        for(int i = 0; i<strs.length; i++){
            char[]charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sorted_str = new String(charArray);
            
            if(ht.containsKey(sorted_str)){
                resultList.add(strs[i]);
                
                int index = ht.get(sorted_str); 
                if(index != -1){
                    resultList.add(strs[index]);
                    ht.put(sorted_str, -1);
                }
            }else{
                ht.put(sorted_str, i);
            }
        }
        return resultList;
    }
}
