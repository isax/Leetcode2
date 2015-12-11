public class Solution {
    // https://leetcode.com/discuss/2978/what-solution-gray-code-problem-extra-space-used-recursion
    // http://blog.csdn.net/linhuanmars/article/details/24511221
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        
        for(int i = 0; i<n; i++){
            int add = 1<<i;
            for(int j = list.size()-1; j>=0; j--){
                int code  = list.get(j) + add;
                list.add(code);
            }
        }
        return list;
    }
}
