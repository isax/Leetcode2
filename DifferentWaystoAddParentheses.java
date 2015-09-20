public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        if(input==null) return new ArrayList<Integer>();
        Map<String, List<Integer>> cache = new HashMap<String, List<Integer>>();
        
        return helper(input, 0, input.length()-1, cache);
    }
    
    private List<Integer> helper(String str, int s, int e, Map<String, List<Integer>> cache){
        List<Integer> list = new ArrayList<Integer>();
        
        // dp
        String substr = str.substring(s, e+1);
        if(cache.containsKey(substr)){
            return cache.get(substr);
        }
        
        boolean isNumber = true;
        
        for(int i = s; i<=e; i++){
            if(str.charAt(i)=='+' || str.charAt(i)=='-' || str.charAt(i)=='*'){
                List<Integer> left = helper(str, s, i-1, cache);
                List<Integer> right = helper(str, i+1, e, cache);
                
                for(int l : left){
                    for(int r : right){
                        if(str.charAt(i)=='+') list.add(l+r);
                        else if(str.charAt(i)=='-') list.add(l-r);
                        else list.add(l*r);
                    }
                }
                isNumber = false;
            }
        }
        if(isNumber){
            list.add(Integer.parseInt(substr));
        }
        cache.put(substr, list);
        
        return list;
    }
}
