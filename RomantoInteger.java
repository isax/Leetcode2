public class Solution {
    // https://leetcode.com/discuss/62728/a-36ms-c-solution-no-hashmap-clean-to-understand
    public int romanToInt(String s) {
        int sum = 0;
        for(int i = 0; i<s.length(); i++){
            int sign = i==s.length()-1?1:checkSign(s.charAt(i), s.charAt(i+1));
            sum += sign*getNum(s.charAt(i));
        }
        return sum;
    }
    
    private int getNum(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return -1;
    }
    
    private int checkSign(char c, char r){
        if(c=='I' && r!='I'){
            return -1;
        }else if(c=='X' && r!='I' && r!='V' && r!='X'){
            return -1;
        }else if(c=='C' && (r=='M'||r=='D')){
            return -1;
        }else if(c=='D' && r=='M'){
            return -1;
        }else{
            return 1;
        }
    }
}
