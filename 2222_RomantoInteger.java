public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            int sign = i==s.length()-1?1:checkSign(s.charAt(i), s.charAt(i+1));
            res += sign*map.get(ch);
        }
        return res;
    }
    
    private int checkSign(char ch1, char ch2){
        if(ch1=='I' && (ch2=='V' || ch2 == 'X')){
            return -1;
        }else if (ch1=='X' && (ch2=='L' || ch2 == 'C')){
            return -1;
        }else if (ch1=='C' && (ch2=='D' || ch2 == 'M')){
            return -1;
        }else{
            return 1;
        }
    }
}
