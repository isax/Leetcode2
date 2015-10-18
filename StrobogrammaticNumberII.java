public class Solution {
    // https://leetcode.com/discuss/50412/ac-clean-java-solution
    public List<String> findStrobogrammatic(int n) {
        return helper2(n, n);
    }
    
    private List<String> helper2(int n, int m){
        List<String> res = new ArrayList<String>();
        if(n==0) return new ArrayList<String>(Arrays.asList(""));
        if(n==1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        
        List<String> list = helper2(n-2, m);
        for(String str: list){
            if(n!=m) res.add("0" + str + "0");
            res.add("1" + str + "1");
            res.add("8" + str + "8");
            res.add("6" + str + "9");
            res.add("9" + str + "6");
        }
        return res;
    }
    
    // Mine
    public List<String> findStrobogrammaticMine(int n) {
        return helper(n, n);
    }
    
    private List<String> helper(int n, int m){
        List<String> res = new ArrayList<String>();
        if(n==0) {
            res.add("");
            return res;
        }
        if(n%2==0) {
            List<String> list = helper(n-2, m);
            for(String str: list){
                res.addAll(addHelper(str, m));
            }
        }else{
            List<String> list = helper(n-1, m);
            for(String str: list){
                res.addAll(addToMidHelper(str));
            }
        }
        return res;
    }
    
    private List<String> addHelper(String str, int n){
        List<String> res = new ArrayList<String>();
        if(str.length()!=n-2 && str.length()!=n-3) res.add("0" + str + "0");
        res.add("1" + str + "1");
        res.add("8" + str + "8");
        res.add("6" + str + "9");
        res.add("9" + str + "6");
        return res;
    }
    
    private List<String> addToMidHelper(String str){
        List<String> res = new ArrayList<String>();
        res.add(str.substring(0, str.length()/2) + "0" + str.substring(str.length()/2));
        res.add(str.substring(0, str.length()/2) + "1" + str.substring(str.length()/2));
        res.add(str.substring(0, str.length()/2) + "8" + str.substring(str.length()/2));
        return res;
    }
    
}
