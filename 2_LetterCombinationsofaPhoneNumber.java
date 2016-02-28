public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        if(digits.length()==0) return list;
        
        list.add("");
        
        for(int i = 0; i<digits.length(); i++){
            char ch = digits.charAt(i);
            String candidates = getLetters(ch);
            List<String> curList = new ArrayList<String>();
            for(int j = 0; j<list.size(); j++) {
                for(int k = 0; k<candidates.length(); k++){
                    curList.add(list.get(j) + candidates.charAt(k));
                }
            }
            list = curList;
        }
        
        return list;
    }
    
    
    public List<String> letterCombinationsBackTracking(String digits) {
        List<String> list = new ArrayList<String>();
        if(digits.length()==0) return list;
        helper(digits, 0, new StringBuilder(), list);
        return list;
    }
    
    private void helper(String digits, int i, StringBuilder sb, List<String> list){
        if(i==digits.length()){
            list.add(sb.toString());
            return;
        }
        
        String candidates = getLetters(digits.charAt(i));
        for(char candidate : candidates.toCharArray()){
            sb.append(candidate);
            helper(digits, i+1, sb, list);
            sb.setLength(sb.length()-1);
        }
    }
    
    private String getLetters(char c){
        
        switch(c){
            case '2':  
                return "abc";  
            case '3':  
                return "def";  
            case '4':  
                return "ghi";  
            case '5':  
                return "jkl";  
            case '6':  
                return "mno";  
            case '7':  
                return "pqrs";  
            case '8':  
                return "tuv";  
            case '9':  
                return "wxyz";  
            case '0':  
                return " ";  
            default:
                return "";
        }
    }
}
