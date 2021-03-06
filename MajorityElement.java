public class Solution {
    public int majorityElement(int[] nums) {
        
        int size = nums.length;
        HashMap<Integer, Integer> occurences = new HashMap<Integer, Integer>();
        
        for(int num: nums){
            if(occurences.containsKey(num)){
                int currentOcur = occurences.get(num);
                occurences.put(num, currentOcur+1);
            }else{
                occurences.put(num,1);
            }
        }
        
        for(Map.Entry<Integer, Integer> entry: occurences.entrySet()){
            if(entry.getValue() > size/2){
                return entry.getKey();
            }
        }
        return -1; //Invalid case
    }
    
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
