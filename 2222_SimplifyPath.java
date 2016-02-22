public class Solution {
    // https://github.com/isax/Leetcode2/blob/master/SimplifyPath.java
    // stack is also fine
    public String simplifyPath(String path) {
        LinkedList<String> list = new LinkedList<String>();
        String[] strs = path.split("/");
        
        for(int i = 0; i<strs.length; i++){
            if(strs[i].equals(".") || strs[i].equals("")){
                continue;
            }else if(strs[i].equals("..")) {
                if(!list.isEmpty()){
                   list.removeLast(); 
                }
            }else{
                list.addLast(strs[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String str : list){
            sb.append("/").append(str);
        }
        return sb.length()!=0?sb.toString():"/";
    }
}
