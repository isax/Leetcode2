public class Solution {
    // https://leetcode.com/discuss/83824/7-lines-easy-java-solution
    public boolean isValidSerialization(String preorder) {
        int diff = 1; // out degree - in degree;
        String[]a = preorder.split(",");
        for(int i = 0; i<a.length; i++){
            String cur = a[i];
            if(--diff<0) return false;
            
            if(!cur.equals("#")) diff += 2;
        }
        return diff==0;
    }
    
    // https://leetcode.com/discuss/83825/simple-python-solution-using-stack-with-explanation
    public boolean isValidSerializationMine(String preorder) {
        String[]a = preorder.split(",");
        
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i<a.length; i++){
            String cur = a[i];
            if(cur.equals("#")){
                while(!stack.isEmpty() && stack.peek().equals("#")){
                    stack.pop();
                    if(!stack.isEmpty()) stack.pop();
                    else return false;
                }
                stack.push("#");
            }else{
                stack.push(cur);
            }
        }
        return stack.size()==1 && stack.peek().equals("#");
    }
}
