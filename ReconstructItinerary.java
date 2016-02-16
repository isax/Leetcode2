public class Solution {
    
    // https://leetcode.com/discuss/84706/share-solution-java-greedy-stack-15ms-with-explanation
    // greedy
    
    // https://leetcode.com/discuss/85668/java-map-with-treeset-based-solution
    public List<String> findItinerary(String[][] tickets) {
        Map<String, Set<String>> iti = new HashMap<String, Set<String>>();
        Map<String, Integer> visited = new HashMap<String, Integer>();
        int len = tickets.length;
        
        for(String [] tt: tickets){
            String origin = tt[0];
            String destination = tt[1];
            if(!iti.containsKey(origin)){
                iti.put(origin, new TreeSet<String>()); // navigatable set !!!!!!!!!!
            }
            iti.get(origin).add(destination);
            String ttKey = origin+"-"+destination;
            if(!visited.containsKey(ttKey)){
                visited.put(ttKey, 0);
            }
            visited.put(ttKey, visited.get(ttKey)+1);
        }
        
        List<String> list = new ArrayList<String>();
        list.add("JFK");
        helper2("JFK", 0, len, list, iti, visited);
        return list;
    }
    
    private boolean helper2(String from, int jump, int len, List<String> list, Map<String, Set<String>> iti, Map<String, Integer> visited){
        if(jump==len){
            return true;
        }
        if(!iti.containsKey(from)) {
            return false; //////////////////// FORGOT...
        }
        
        Set<String> next = iti.get(from);
        for(String to : next){
            String ttKey = from + "-" + to;
            if(visited.get(ttKey) > 0){
                visited.put(ttKey, visited.get(ttKey)-1);
                list.add(to);
                if(helper2(to, jump+1, len, list, iti, visited)) return true;
                visited.put(ttKey, visited.get(ttKey)+1);
                list.remove(list.size()-1);
            }
        }
        return false;
    }
    
    
    // Mine
    public List<String> findItinerary2(String[][] tickets) {
        Map<String, List<String>> iti = new HashMap<String, List<String>>();
        Map<String, List<Boolean>> visited = new HashMap<String, List<Boolean>>();
        int len = tickets.length;
        
        for(String [] tt: tickets){
            String origin = tt[0];
            String destination = tt[1];
            if(!iti.containsKey(origin)){
                iti.put(origin, new ArrayList<String>());
                visited.put(origin, new ArrayList<Boolean>());
            }
            iti.get(origin).add(destination);
            visited.get(origin).add(false);
        }
        
        for(List<String> list: iti.values()){
            Collections.sort(list);
        }
        
        List<String> list = new ArrayList<String>();
        list.add("JFK");
        helper("JFK", 0, len, list, iti, visited);
        return list;
    }
    
    private boolean helper(String cur, int jump, int len, List<String> list, Map<String, List<String>> iti, Map<String, List<Boolean>> visited){
        if(jump==len){
            return true;
        }
        if(!iti.containsKey(cur)) {
            return false; //////////////////// FORGOT...
        }
        
        List<String> next = iti.get(cur);
        for(int i = 0; i<next.size(); i++){
            if(!visited.get(cur).get(i)){
                visited.get(cur).set(i, true);
                list.add(next.get(i));
                if(helper(next.get(i), jump+1, len, list, iti, visited)) return true;
                visited.get(cur).set(i, false);
                list.remove(list.size()-1);
            }
        }
        return false;
    }
}
