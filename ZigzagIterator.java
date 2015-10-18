public class ZigzagIterator {
    //https://leetcode.com/discuss/58683/c-with-queue-compatible-with-k-vectors
    private LinkedList<Iterator> list;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<Iterator>();
        if(v1!=null && !v1.isEmpty()) {
            Iterator i1 = v1.iterator();
            list.add(i1);
        }
        if(v2!=null && !v2.isEmpty()){
            Iterator i2 = v2.iterator();
            list.add(i2);
        }
    }

    public int next() {
        Iterator i = list.poll();
        int res = (Integer)i.next();
        if(i.hasNext()) list.add(i);
        return res;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
