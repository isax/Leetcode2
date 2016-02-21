public class TwoSum {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
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
	        int remaining = value - i;
	        if(map.containsKey(remaining) && (remaining!=i || map.get(i)>1)){
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
