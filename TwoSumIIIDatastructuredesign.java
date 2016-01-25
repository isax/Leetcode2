public class TwoSum {
    // https://leetcode.com/discuss/76146/trade-off-in-this-problem-should-be-considered
    // https://leetcode.com/discuss/73775/my-beats-99-49%25-java-submission

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    // Add the number to an internal data structure.
	public void add(int number) {
	    if(map.containsKey(number)){
	        map.put(number, map.get(number)+1);
	    }else{
	        map.put(number, 1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for(int i : map.keySet()){
	        int remain = value - i;
	        if(map.containsKey(remain) && (remain!=i || map.get(remain)>1)){
	            return true;
	        }
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
