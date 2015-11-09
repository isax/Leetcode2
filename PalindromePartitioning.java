public class Solution {
    
    // backtracking
    // https://leetcode.com/discuss/29765/clean-c-backtracking-solution
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        
        helper(s, 0, res, new ArrayList<String>());
        return res;
    }
        
    private void helper(String s, int start, List<List<String>> lists, List<String>list){
        if(start==s.length()){
            lists.add(new ArrayList<String>(list));
            return;
        }
        
        for(int i = start; i<s.length(); i++){
            if(isPalindrome(s, start, i)){
                list.add(s.substring(start, i+1));
                helper(s, i+1, lists, list);
                list.remove(list.size()-1);
            }
        }
    } 
    
    private boolean isPalindrome(String s, int l, int r){
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++; r--;
        }
        return true;
    }
         
    
    
    // https://leetcode.com/discuss/9623/my-java-dp-only-solution-without-recursion-o-n-2
    public List<List<String>> partitionDP(String s) {
        int len = s.length();
        List<List<String>>[] res = new List[len+1];
        res[0] = new ArrayList<List<String>>();
        res[0].add(new ArrayList<String>());
        
        boolean[][] dp = new boolean[len][len]; // if i---j is palindrome
        
        for(int i = 0; i<len; i++){
            res[i + 1] = new ArrayList<List<String>>();
            
            for(int left = 0; left<=i; left++){
                if(s.charAt(i)==s.charAt(left) && (left>i-2 || dp[left+1][i-1])){
                    dp[left][i] = true;
                    String newPalindrome = s.substring(left, i+1);
                    for(List<String>list:res[left]){
                        List<String>curList = new ArrayList<String>(list);
                        curList.add(newPalindrome);
                        res[i+1].add(curList);
                    }
                }
            }
        }
        return res[len];
    }
    
    
    
    public List<List<String>> partitionNotWorking(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        
        for(int i = 0; i<s.length(); i++){
            if(i==0) {
                List<String> list = new ArrayList<String>();
                list.add(s.charAt(i)+"");
                res.add(list);
                continue;
            }
            int size = res.size();
            for(int n = 0; n<size; n++){
                List<String> list = res.get(n);
                list.add(s.charAt(i)+"");
                
                for(int j = 0; j<list.size()-1 ;j++){
                    String strToCheck = list.get(j);
                    if(strToCheck.equals(s.charAt(i)+"")){
                        List<String> newList = j-1>=0?new ArrayList<String>(list.subList(0,j-1)):new ArrayList<String>();
                        newList.add(s.substring(j, i+1));
                        res.add(newList);
                    }
                }
            }
        }
        return res;
    }
}
