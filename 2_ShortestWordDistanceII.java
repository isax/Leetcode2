public class WordDistance {
    Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
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
        
        int p = 0, q = 0;
        int shortest = Integer.MAX_VALUE;
        while(p<l1.size() && q<l2.size()){
            shortest = Math.min(shortest, Math.abs(l1.get(p)-l2.get(q)));
            if(l1.get(p)<l2.get(q)){
                p++;
            }else{
                q++;
            }
        }
        return shortest;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
