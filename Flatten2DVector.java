public class Vector2D {
    private Iterator<Integer> x;
    private Iterator<List<Integer>> y;
    
    // https://leetcode.com/discuss/50292/7-9-lines-added-java-and-c-o-1-space
    public Vector2D(List<List<Integer>> vec2d) {
        y = vec2d.iterator();
    }

    public int next() {
        hasNext();
        return x.next();
    }
    
    public boolean hasNext() {
        while( (x==null || !x.hasNext()) && y.hasNext()){
            x = y.next().iterator();
        }
        if(x==null) return false;
        else return x.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
