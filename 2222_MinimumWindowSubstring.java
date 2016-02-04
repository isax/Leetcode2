public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i<t.length(); i++){
            char ch = t.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, 1);
            }else{
                map.put(ch, map.get(ch)+1);
            }
        }
        
        int min = Integer.MAX_VALUE;
        int minS = 0, minE = 0;
        int left = 0, right = 0;
        int count = 0;
        while(right<s.length()){
            char ch = s.charAt(right);
            
            if(map.containsKey(ch)){
                if(map.get(ch)>0) count++;
                map.put(ch, map.get(ch)-1);
                
                while(count==t.length()){
                    if(right-left+1 < min){
                        min = right-left+1;
                        minS = left; 
                        minE = right;
                    }
                    
                    char c = s.charAt(left);
                    if(map.containsKey(c)){
                        map.put(c, map.get(c)+1);
                        if(map.get(c)>0){
                           count--;
                        }
                    }
                    left++;
                }
            }
            right++;
        }
        if(min==Integer.MAX_VALUE) return "";
        else return s.substring(minS, minE+1);
    }
}
