public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String>[] cache = new List[n+1];
        cache[0] = Arrays.asList("");
        cache[1] = Arrays.asList("0","8","1");
        
        for(int i = 2; i<=n; i++){
            cache[i] = new ArrayList<String>();
            
            for(String str : cache[i-2]){
                cache[i].add("1"+str+"1");
                cache[i].add("6"+str+"9");
                cache[i].add("9"+str+"6");
                if(i!=n) cache[i].add("0"+str+"0");
                cache[i].add("8"+str+"8");
            }
        }
        return cache[n];
    }
}
