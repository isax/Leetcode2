/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    // https://leetcode.com/discuss/56350/straight-forward-c-solution-with-explaination
    public int findCelebrity(int n) {
        int candidate = 0;
        // first check
        for(int i = 0; i<n; i++){
            if(knows(candidate, i)){
                candidate = i;
            }
        }
        
        // verify
        for(int i = 0; i<n; i++){
            if(i==candidate) continue;
            
            if(knows(candidate, i) || !knows(i, candidate)) return -1;
        }
        return candidate;
    }
}
