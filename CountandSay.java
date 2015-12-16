public class Solution {
    public String countAndSay(int n) {
        String str = "1";
        
        for(int j = 1; j<n; j++) {
            StringBuilder temp = new StringBuilder();
            int i = 0;
            while(i<str.length()){
                char curBit = str.charAt(i);
                int count = 1;
                
                while(++i<str.length() && str.charAt(i)==curBit){
                    count++;
                }
                temp.append(count);
                temp.append(curBit);
            }
            str = temp.toString();
        }
        return str;
    }
}
