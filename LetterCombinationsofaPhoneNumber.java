public class Solution {
    // Iterative
    // http://blog.csdn.net/linhuanmars/article/details/19743197
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        if(digits.length()==0) return list;
        list.add("");
        for(int i = 0; i<digits.length(); i++){
            char num = digits.charAt(i);
            String candidates = getLetters(num);
            List<String> curList = new ArrayList<String>();
            
            for(int k = 0; k<list.size(); k++){
                for(int j = 0; j<candidates.length(); j++){
                    curList.add(list.get(k) + candidates.charAt(j));
                }
            }
            list = curList;
        }
        
        return list;
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
    
    
    public List<String> letterCombinationsMine(String digits) {
        List<String> list = new ArrayList<String>();
        if(digits.length()==0) return list;
        Map<Character, List<Character>> map = createMap();
        helper(0, digits, new StringBuilder(), list, map);
        return list;
    }
    
    private void helper(int i, String digits, StringBuilder sb, List<String> list, Map<Character, List<Character>> map){
        if(i==digits.length()) {
            list.add(sb.toString());
            return;
        }
        
        List<Character> candidates = map.get(digits.charAt(i));
        for(char ch : candidates){
            sb.append(ch);
            helper(i+1, digits, sb, list, map);
            sb.setLength(sb.length()-1);
        }
    }
    
    private Map<Character, List<Character>> createMap(){
        Map<Character, List<Character>> map = new HashMap<Character, List<Character>>();
        map.put('1', Collections.emptyList());
        map.put('2', Arrays.asList('a','b','c'));
        map.put('3', Arrays.asList('d','e','f'));
        map.put('4', Arrays.asList('g','h','i'));
        map.put('5', Arrays.asList('j','k','l'));
        map.put('6', Arrays.asList('m','n','o'));
        map.put('7', Arrays.asList('p','q','r','s'));
        map.put('8', Arrays.asList('t','u','v'));
        map.put('9', Arrays.asList('w','x','y','z'));
        return map;
    }
}
