public class Solution {
    //https://leetcode.com/discuss/20509/share-my-java-solution-with-comments
    
    public String convert(String s, int numRows) {
        if(numRows<=1) return s;
        
        StringBuilder [] sb = new StringBuilder[numRows];
        for(int i = 0; i<numRows; i++){
            sb[i] = new StringBuilder();
        }
        
        char [] charArray = s.toCharArray();
        
        for(int i = 0; i<charArray.length; i++){
            int index = i%(2*numRows-2);
            if(index<numRows){
                sb[index].append(charArray[i]);
            }else{
                sb[2*numRows-2-index].append(charArray[i]);
            }
        }
        
        StringBuilder res = new StringBuilder();
        for(int i = 0; i<numRows; i++){
            res.append(sb[i].toString());
        }
        return res.toString();
    }
}
