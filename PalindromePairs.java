public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Map<String, Integer> dictionary = new HashMap<String, Integer>();
        for(int i = 0; i<words.length; i++){
            dictionary.put(words[i], i);
        }
        
        for(int i = 0; i<words.length; i++){
            String word = words[i];
            String reversedWord = new StringBuilder(word).reverse().toString();
            for(String candidate : getCandidate(word, true)){ // <-
                if(dictionary.containsKey(candidate)){
                    int j = dictionary.get(candidate);
                    if(candidate.length()!=word.length() || i<j){
                        lists.add(Arrays.asList(j, i));
                    }
                }
            }
            for(String candidate : getCandidate(reversedWord, false)){ // ->
                if(dictionary.containsKey(candidate)){
                    int j = dictionary.get(candidate);
                    if(candidate.length()!=word.length() || i<j){
                        lists.add(Arrays.asList(i, j));
                    }
                }
            }
        }
        
        return lists;
    }
    
    private List<String> getCandidate(String word, boolean forward){
        List<String> res = new ArrayList<String>();
        boolean [][] isPal = new boolean[word.length()][word.length()];
        
        for(int i = -1; i<word.length();i++){
            for(int j = 0; j<=i; j++){
                if(word.charAt(i)==word.charAt(j) && (i-j<=1 || isPal[j+1][i-1])){
                    isPal[j][i] = true;
                }
            }
            if(i==-1 || isPal[0][i]){
                if(forward){
                    res.add(new StringBuilder(word.substring(i+1)).reverse().toString());
                }else{
                    res.add(word.substring(i+1));
                }
            }
        }
        return res;
    }
}
