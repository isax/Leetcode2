public class Solution {
    // https://leetcode.com/discuss/67031/one-pass-java-solution
    public String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        int [] map = new int[10];
        
        for(int i = 0; i<secret.length(); i++){
            char ch1 = secret.charAt(i);
            char ch2 = guess.charAt(i);
            if(ch1 == ch2){
                bull++;
                continue;
            }
            
            if(map[ch1-'0']++ < 0) {
                cow++;
            }
            if(map[ch2-'0']-- > 0) {
                cow++;
            }
        }
        
        return bull + "A" + cow + "B";
    }
    
    public String getHint2(String secret, String guess) {
        int bull = 0, cow = 0;
        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        
        for(int i = 0; i<secret.length(); i++){
            char ch1 = secret.charAt(i);
            char ch2 = guess.charAt(i);
            if(ch1 == ch2){
                bull++;
                continue;
            }
            if(!hm.containsKey(ch1)){
                hm.put(ch1, 1);
            }else{
                if(hm.get(ch1) < 0) {
                    cow++;
                }
                hm.put(ch1, hm.get(ch1)+1);
            }
            
            if(!hm.containsKey(ch2)){
                hm.put(ch2, -1);
            }else{
                if(hm.get(ch2)> 0) {
                    cow++;
                }
                hm.put(ch2, hm.get(ch2)-1);
            }
        }
        
        return bull + "A" + cow + "B";
    }
    
    public String getHintMine(String secret, String guess) {
        int bull = 0, cow = 0;
        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        
        for(int i = 0; i<secret.length(); i++){
            char ch = secret.charAt(i);
            if(ch == guess.charAt(i)){
                bull++;
                continue;
            }
            if(!hm.containsKey(ch)){
                hm.put(ch, 1);
            }else{
                hm.put(ch, hm.get(ch)+1);
            }
        }
        
        for(int i = 0; i<guess.length(); i++){
            char ch = guess.charAt(i);
            if(ch==secret.charAt(i) || !hm.containsKey(ch)){
                continue;
            }
            if(hm.get(ch)>0){
                hm.put(ch, hm.get(ch)-1);
                cow++;
            }
        }
        return bull + "A" + cow + "B";
    }
}
