public class Solution {
    // http://bookshadow.com/weblog/2015/12/19/leetcode-bulb-switcher/
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
    
    // https://leetcode.com/discuss/75808/my-0-ms-c-solution-with-explanation
    public int bulbSwitch2(int n) {
        int count = 0;
        
        for(int i = 1; i*i<=n;i++){
            count++;
        }
        return count;
    }
}
