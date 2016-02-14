public class Solution {
    public boolean isStrobogrammatic(String num) {
        int l = 0, r = num.length()-1;
        
        while(l<=r){
            if(!symmetric(num.charAt(l), num.charAt(r))){
                return false;
            }
            l++; r--;
        }
        return true;
    }
    
    private boolean symmetric(char a, char b){
        return a=='6'&&b=='9' || a=='0' && b=='0'
        || a=='9' && b=='6' || a=='8'&& b=='8' ||a=='1'&&b=='1';
    }
}
