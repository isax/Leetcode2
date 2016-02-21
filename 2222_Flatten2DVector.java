public class Vector2D {
    Iterator<List<Integer>>i;
    Iterator<Integer>j;
    
    public Vector2D(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
    }

    public int next() {
        hasNext();
        return j.next();
    }

    public boolean hasNext() {
        while((j==null || !j.hasNext()) && i.hasNext()){
            j = i.next().iterator();
        }
        if(j==null) return false;
        else return j.hasNext();
    }
    
    /*
    Queue<Iterator> its = new LinkedList<Iterator>();
    
    public Vector2D(List<List<Integer>> vec2d) {
        for(List<Integer>list:vec2d){
            if(!list.isEmpty()) {
                its.offer(list.iterator());
            }
        }
    }

    public int next() {
        if(hasNext()){
            Iterator it = its.peek();
            int next = (int)it.next();
            if(!it.hasNext()) its.poll();
            return next;
        }
        return Integer.MIN_VALUE;
    }

    public boolean hasNext() {
        return !its.isEmpty();
    }*/
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
