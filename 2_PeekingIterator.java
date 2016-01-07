// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Integer current; 
    private Iterator<Integer> it;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.it = iterator;
	    if(it.hasNext()) current = it.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return current;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer temp = current;
	    if(it.hasNext()){
	        current = it.next();
	    }else{
	        current = null;
	    }
	    return temp;
	}

	@Override
	public boolean hasNext() {
	    return current!=null;
	}
}
