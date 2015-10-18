public class Solution {
    // https://leetcode.com/discuss/50359/my-concise-java-solution
    public boolean isStrobogrammatic(String num) {
        int left = 0;
        int right = num.length()-1;
        
        while(left<=right){
            switch(num.charAt(left)){
                case '0':
                case '1':
                case '8':
                    if(num.charAt(left)!=num.charAt(right)) return false;
                    break;
                case '6':
                    if(num.charAt(right)!='9') return false;
                    break;
                case '9':
                    if(num.charAt(right)!='6') return false;
                    break;
                default:
                    return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    public boolean isStrobogrammaticNoSwitch(String num) {
        int left = 0;
        int right = num.length()-1;
        
        while(left<=right){
            if(!isSChars(num.charAt(left), num.charAt(right))) return false;
            left++;
            right--;
        }
        return true;
    }
    
    private boolean isSChars(char c, char h){
        if(c=='6') return h=='9';
        else if(c=='9') return h=='6';
        else if(c=='8' || c=='1' || c=='0') return h==c;
        
        return false;
    }
}
