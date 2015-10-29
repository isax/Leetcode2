public class WordDistance {

    // https://leetcode.com/discuss/50190/java-solution-using-hashmap
    private Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    
    public WordDistance(String[] words) {
        for(int i = 0; i<words.length; i++){
            if(!map.containsKey(words[i])){
                map.put(words[i], new ArrayList<Integer>());
            }
            map.get(words[i]).add(i);
        }
    }
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        for(int i = 0, j = 0; i<l1.size()&&j<l2.size();){
            int index1 = l1.get(i), index2 = l2.get(j);
            if(index1<index2){
                min = Math.min(min, index2-index1);
                i++;
            }else{
                min = Math.min(min, index1-index2);
                j++;
            }
        }
        return min;
    }
    
    // TLE
    private String [] words;
    private Map<String, Map<String, Integer>> map = new HashMap<String, Map<String, Integer>>();
    
    public WordDistance(String[] words) {
        this.words = words;
    }

    public int shortest(String word1, String word2) {
        String key = word1;
        String value = word2;
        if(word1.compareTo(word2)>0) {
            key = word2; 
            value = word1;
        }
        
        if(map.containsKey(key) && map.get(key).containsKey(value)) return map.get(key).get(value);
        
        int p = -1, q = -1;
        int shortest = words.length;
        for(int i = 0; i<words.length; i++){
            if(words[i].equals(word1)) p = i;
            if(words[i].equals(word2)) q = i;
            if(!words[i].equals(word1) && !words[i].equals(word2)) continue;
            
            if(p!=-1 && q!=-1){
                shortest = Math.min(shortest, Math.abs(p-q));
            }
        }
        if(!map.containsKey(key)){
             Map<String, Integer> m = new HashMap<String, Integer>();
             map.put(key, m);
        }
        map.get(key).put(value, shortest);
        
        return shortest;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
