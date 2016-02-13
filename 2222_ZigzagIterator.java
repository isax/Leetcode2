public class ZigzagIterator {
    // //https://leetcode.com/discuss/58683/c-with-queue-compatible-with-k-vectors
    LinkedList<Iterator> its = new LinkedList<Iterator>();
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        if(v1!=null && !v1.isEmpty()) its.add(v1.iterator());
        if(v2!=null && !v2.isEmpty()) its.add(v2.iterator());
    }

    public int next() {
        Iterator i = its.removeFirst();
        int res = (Integer)i.next();
        if(i.hasNext()) its.addLast(i);
        return res;
    }

    public boolean hasNext() {
        return !its.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
