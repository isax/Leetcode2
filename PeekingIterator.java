// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private final Iterator<Integer> iterator;
    
    // CACHE
    private Integer top;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	    
	    if(iterator.hasNext()){
	        top = iterator.next();
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return top;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int next = top;
	    if(iterator.hasNext()){
	        top = iterator.next();
	    }else{
	        top = null;
	    }
	    return next;
	}

	@Override
	public boolean hasNext() {
	    return top!=null;
	}
}
