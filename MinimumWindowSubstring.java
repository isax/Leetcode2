public class Solution {

    // http://blog.csdn.net/linhuanmars/article/details/20343903
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        
        for(char c : t.toCharArray()){
            if(!hm.containsKey(c)) hm.put(c, 1);
            else hm.put(c, hm.get(c)+1);
        }
        
        int count = 0;
        int minLen = s.length()+1; // dont set it to 0
        int minStart = 0;
        for(int left = 0, right = 0; right<s.length(); right++){
            
            char c = s.charAt(right);
            
            if(hm.containsKey(c)){
                if(hm.get(c)>0){
                    count++;
                }
                hm.put(c, hm.get(c)-1);
                
                while(count==t.length()){
                    if(right-left+1<minLen){
                        minLen = right-left+1;
                        minStart = left;
                    }
                    
                    if(hm.containsKey(s.charAt(left))){
                        hm.put(s.charAt(left), hm.get(s.charAt(left))+1);
                        if(hm.get(s.charAt(left))>0){
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        if(minLen==s.length()+1) return "";
        else return s.substring(minStart, minStart+minLen);
    }
}
