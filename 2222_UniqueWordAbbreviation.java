public class ValidWordAbbr {
    Map<String, String> map = new HashMap<String, String>();
    
    public ValidWordAbbr(String[] dictionary) {
        for(String str : dictionary){
            String key = getAbbr(str);
            if(map.containsKey(key) && !map.get(key).equals(str)){//////////////!map.get(key).equals(str)
                map.put(key, "");
            }else{
                map.put(key, str);
            }
        }
    }
    
    private String getAbbr(String str){
        if(str.length()<=2) return str;
        else return ""+str.charAt(0)+ (str.length()-2) + str.charAt(str.length()-1);
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        if(!map.containsKey(abbr) || map.get(abbr).equals(word)){
            return true;
        }else{
            return false;
        }
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
