public class Solution {
    
    // Early pruning 
    // https://leetcode.com/discuss/74549/116ms-c-solution-use-early-pruning-faster-than-most-o-n-2
    public int maxProduct(String[] words) {
        int max = 0;
        int [] bit = new int[words.length];
        
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String s1, String s2){
                return s2.length()-s1.length();
            }
        });
        
        for(int i = 0; i<words.length; i++){
            for(char c:words[i].toCharArray()) bit[i] |= 1<<(c-'a');
        }
        
        for(int i = 0; i<words.length; i++){
            if(words[i].length()*words[i].length()<=max) break; // early pruning
            
            for(int j = i+1; j<words.length; j++){
                if(words[i].length()*words[j].length()<=max) break; // early pruning
                if((bit[i]&bit[j])==0) max = Math.max(max, words[i].length()*words[j].length());
            }
        }
        return max;
    }
    
    // brute force
    public int maxProductBrute(String[] words) {
        int max = 0;
        
        for(int i = 0; i<words.length; i++){
            int [] map = new int[26];
            for(char c:words[i].toCharArray()){
                map[c-'a']++;
            }
            for(int j = i+1; j<words.length; j++){
                boolean noDuplicate = true;
                for(char c:words[j].toCharArray()){
                    if(map[c-'a']!=0) {
                        noDuplicate = false;
                        break;
                    }
                }
                if(noDuplicate) max = Math.max(words[i].length()*words[j].length(), max);
            }
        }
        return max;
    }
}
