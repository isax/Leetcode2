public class Solution {
    
    Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    public List<Integer> diffWaysToCompute(String input) {
        if(map.containsKey(input)) return map.get(input);
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i<input.length(); i++){
            if(isOperator(input.charAt(i))){
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                
                for(int l : left){
                    for(int r : right){
                        int num = calculate(input.charAt(i), l, r);
                        res.add(num);
                    }
                }
            }
        }
        if(res.isEmpty()) { // just number
            res = Collections.singletonList(Integer.valueOf(input));
        }
        
        map.put(input, res);
        
        return res;
    }
    
    private boolean isOperator(char ch){
        return ch=='+' || ch == '-' || ch=='*';
    }
    
    private int calculate(char ch, int l, int r){
        switch(ch){
            case '+':
                return l+r;
            case '-':
                return l-r;
            case '*':
                return l*r;
        }
        return -1;
    }
}
