public class Solution {
    // https://leetcode.com/discuss/29765/clean-c-backtracking-solution
    // O(n * 2^n) = 2 ^ n (number of possible partitions) * n (sum of checking palindrome for each partition)
    public List<List<String>> partitionDFS(String s) {
        List<List<String>> lists = new ArrayList<List<String>>();
        
        helper(s, 0, new ArrayList<String>(), lists);
        return lists;
    }
    
    private void helper(String s, int start, List<String> list, List<List<String>>lists){
        if(start==s.length()){
            lists.add(new ArrayList<String>(list));
            return;
        }
        
        for(int i = start; i<s.length(); i++){
            if(isPal(s, start, i)){
                list.add(s.substring(start, i+1));
                helper(s, i+1, list, lists);
                list.remove(list.size()-1);
            }
        }
    }
    
    private boolean isPal(String s, int l, int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
    
    // https://leetcode.com/discuss/9623/my-java-dp-only-solution-without-recursion-o-n-2
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> [] res = new List[len+1];
        res[0] = new ArrayList<List<String>>();
        res[0].add(new ArrayList<String>());
        
        boolean[][] dp = new boolean[len][len];     
        
        for(int i = 0; i<len; i++){
             res[i+1] = new ArrayList<List<String>>();
             for(int j = 0; j<=i; j++){
                 if(s.charAt(i)==s.charAt(j) && (j>i-2 || dp[j+1][i-1])){ // j..i is pal
                    dp[j][i] = true;
                    String newPalindrome = s.substring(j, i+1);
                    for(List<String>list:res[j]){
                        List<String>curList = new ArrayList<String>(list);
                        curList.add(newPalindrome);
                        res[i+1].add(curList);
                    }
                }
             }
        }
        return res[len];
    }
}
