public class Solution {
    //https://leetcode.com/discuss/73761/a-short-o-n-recursive-greedy-solution
    
    
    // https://leetcode.com/discuss/73824/short-16ms-solution-using-stack-which-can-optimized-down-4ms
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<Character>();
        boolean[]inResult = new boolean[26];
        int [] count = new int[26];
        
        for(int i = 0; i<s.length(); i++){
            count[s.charAt(i)-'a']++;
        }
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            count[ch-'a']--; // otherwise bbcaac will return ac
            
            if(inResult[ch-'a']) continue;
            
            while(!stack.isEmpty() && stack.peek()>ch && count[stack.peek()-'a']>0){
                inResult[stack.pop()-'a'] = false;
            }
            stack.push(ch);
            inResult[ch-'a'] = true;
            //count[ch-'a']--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
        
    }
    
    // https://leetcode.com/discuss/73777/easy-to-understand-iterative-java-solution
    public String removeDuplicateLettersIterative(String s) {
        Map<Character, Integer> lastOccurence = new HashMap<Character, Integer>();
        for(int i = 0; i<s.length(); i++){
            lastOccurence.put(s.charAt(i), i);
        }
        
        int count = lastOccurence.size();
        StringBuilder sb = new StringBuilder();
        int start = 0, end = findMin(lastOccurence);
        while(sb.length()<count){
            int i = findSmallest(s, start, end, lastOccurence);
            sb.append(s.charAt(i));
            lastOccurence.remove(s.charAt(i));
            start = i+1;
            
            //if(start>end) end = findMin(lastOccurence); -> baab
            if(s.charAt(i)==s.charAt(end)) end = findMin(lastOccurence);
        }
        return sb.toString();
    }
    
    private int findMin(Map<Character, Integer> map){
        int min = Integer.MAX_VALUE;
        for(Integer i : map.values()){
            min = Math.min(min, i);
        }
        return min;
    }
    private int findSmallest(String s, int start, int end, Map<Character, Integer> map){
        int res = -1;
        for(int i = start; i<=end; i++){
            if(map.containsKey(s.charAt(i))&& (res==-1 || s.charAt(i)<s.charAt(res))){
                res = i;
            }
        }
        return res;
    }
}
