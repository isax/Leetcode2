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
}
