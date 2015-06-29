public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        
        for(int num: nums){
           if(!hs.add(num)){
               return true;
           }
        }
        return false;
    }
    
    /*
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        for(int num: nums){
            if(hm.containsKey(num)){
                int count = hm.get(num);
                hm.put(num, count+1);
            }else{
                hm.put(num,1);
            }
        }
        
        for(Map.Entry<Integer, Integer> entry: hm.entrySet()){
            if(entry.getValue() > 1){
                return true;
            }
        }
        return false;
    }*/
}
