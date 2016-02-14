public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> list = new ArrayList<String>();
        helper(word, 0, 0, new StringBuilder(), list);
        return list;
    }

    private void helper(String word, int cur, int curCount, StringBuilder sb, List<String> list){
        if(cur==word.length()){
            String end = curCount==0?"":curCount+"";
            list.add(sb.toString()+end);
            return;
        }
        // to abbreviate current char
        helper(word, cur+1, curCount+1, sb, list);

        // not to abbreviate
        int len = sb.length();
        if(curCount!=0) sb.append(curCount);
        sb.append(word.charAt(cur));
        helper(word, cur+1, 0, sb, list);
        sb.setLength(len);
    }
    
    ////////////////////////////////////////////////////
    
    public List<String> generateAbbreviations(String word) {
        List<String> list = new ArrayList<String>();
        helper(word, 0, 0, new StringBuilder(), list);
        return list;
    }
    
     private void helper(String word, int cur, int curCount, StringBuilder sb, List<String> list){
        if(cur==word.length()){
            String end = curCount==0?"":curCount+"";
            list.add(sb.toString()+end);
            return;
        }
        // abbreviate current char
        helper(word, cur+1, curCount+1, sb, list);
        
        // not to abbreviate
        int len = sb.length();
        if(curCount!=0) sb.append(curCount);
        sb.append(word.charAt(cur));
        helper(word, cur+1, 0, sb, list);
        sb.setLength(len);
    }
    
    // NOT WORKING
    public List<String> generateAbbreviationsWRONG(String word) {
        List<String> list = new ArrayList<String>();
        helper(word, 0, new StringBuilder(), list);
        return list;
    }
    
    private void helper(String word, int cur, StringBuilder sb, List<String> list){
        if(cur==word.length()){
            list.add(sb.toString());
            return;
        }
        int len = sb.length();
        // cur keep and dfs
        sb.append(word.charAt(cur));
        helper(word, cur+1, sb, list);
        sb.setLength(len);
        
        // cur char  + 1 and dfs
        sb.append(word.charAt(cur)).append(1);
        helper(word, cur+1, sb, list);
        sb.setLength(len);
        
        // merge to prev
        if(len>0 && Character.isDigit(sb.charAt(len-1))){// can merge
            String prevCount = "";
            int i = len-1;
            while(Character.isDigit(sb.charAt(i))){
                prevCount = sb.charAt(i) + prevCount;
                i--;
            }
            int count = Integer.parseInt(prevCount);
            //sb.setLength(len - prevCount.length());
            StringBuilder newSB = new StringBuilder(sb.substring(0, len-prevCount.length())).append(count+1);
            helper(word, cur+1, newSB, list);
        }
    }
}
