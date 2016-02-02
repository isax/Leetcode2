public class Solution {
    
    public int maxProduct(String[] words) {
        int[] bit = new int[words.length];
        
        Arrays.sort(words, new Comparator<String>(){
           public int compare(String a, String b){
               return a.length()-b.length(); // short length to left
           } 
        });
        
        for(int i = 0; i<words.length; i++){
            for(char ch : words[i].toCharArray()) bit[i] |= 1<<(ch-'a');
        }
        
        int max = 0;
        for(int i = words.length-1; i>=0; i--){
            if(words[i].length()*words[i].length()<=max) break;
            for(int j = i-1; j>=0; j--){
                if(words[i].length()*words[j].length()<=max) break;
                
                if((bit[i]&bit[j])==0) max = Math.max(max, words[i].length()*words[j].length());
            }
        }
        return max;
    }
    
    public int maxProductBF(String[] words) {
        int max = 0;
        
        for(int i = 0; i<words.length; i++){
            boolean [] map = new boolean[26];
            char[] chs = words[i].toCharArray();
            
            for(int j = 0; j<chs.length; j++){
                map[chs[j]-'a'] = true;
            }
            
            for(int j = i+1; j<words.length; j++){
                char[] chs_another = words[j].toCharArray();
                boolean dup = false;
                for(int n = 0; n<chs_another.length; n++){
                    if(map[chs_another[n]-'a']) {
                        dup = true;
                        break;
                    }
                }
                if(!dup) max = Math.max(max, chs.length*chs_another.length);
            }
        }
        return max;
    }
}
