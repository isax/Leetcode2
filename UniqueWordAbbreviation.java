public class ValidWordAbbr {
    // https://leetcode.com/discuss/71652/java-solution-with-hashmap-string-string-beats-submissions
    Map<String, String> hm = new HashMap<String, String>();
    
    public ValidWordAbbr(String[] dictionary) {
        for(String str : dictionary){
            String abbr = getAbbreviation(str);
            if(hm.containsKey(abbr)){
                if(!hm.get(abbr).equals(abbr)){
                    hm.put(abbr, "");
                }
            }else{
                hm.put(abbr, str);
            }
        }
    }
    
    private String getAbbreviation(String str){
        if(str.length()<=2) return str; //return null;
        return "" + str.charAt(0) + (str.length()-2) + str.charAt(str.length()-1);
    }

    public boolean isUnique(String word) {
        String abbr = getAbbreviation(word);
        if(!hm.containsKey(abbr) || hm.get(abbr).equals(word)) {
            return true;
        }else{
            return false;
        }
    }
    
    /* Mine
    Map<String, Set<String>> hm = new HashMap<String, Set<String>>();
    
    public ValidWordAbbr(String[] dictionary) {
        for(String str : dictionary){
            String abbr = getAbbreviation(str);
            if(abbr!=null) {
                if(!hm.containsKey(abbr)){
                    hm.put(abbr, new HashSet<String>());
                }
                hm.get(abbr).add(str);
            }
        }
    }
    
    private String getAbbreviation(String str){
        if(str.length()<=2) return null;
        
        return "" + str.charAt(0) + (str.length()-2) + str.charAt(str.length()-1);
    }

    public boolean isUnique(String word) {
        String abbr = getAbbreviation(word);
        if(abbr==null || !hm.containsKey(abbr) || hm.get(abbr).contains(word) && hm.get(abbr).size()==1) {
            return true;
        }else{
            return false;
        }
    }*/
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
