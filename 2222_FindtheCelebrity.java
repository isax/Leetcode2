/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if(n==0 || n==1) return -1;
        
        int candidate = 0;
        
        for(int i = 1; i<n; i++){
            if(knows(candidate, i)){
                candidate = i;
            }
        }
        
        for(int i = 0; i<n; i++){
            if(i!=candidate && (!knows(i, candidate) || knows(candidate, i))) return -1;
        }
        return candidate;
    }
    
    public int findCelebrityMine(int n) {
        if(n==0 || n==1) return -1;
        
        int candidate = 0;
        
        for(int i = 0; i<n; i++){
            if(candidate==i){
                continue;
            }
            
            if(!knows(i, candidate) && knows(candidate, i)){
                candidate = i;
            }else if(knows(i, candidate) && knows(candidate, i)){
                candidate = i==n-1?-1:i+1;
            }
        }
        
        if(candidate==-1) return -1;
        
        for(int i = 0; i<n; i++){
            // dont miss the i != candidate
            if(i!=candidate && (!knows(i, candidate) || knows(candidate, i))) return -1;
        }
        return candidate;
    }
}
