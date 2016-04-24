/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    // https://leetcode.com/discuss/98401/java-9ms-stack-with-iterator
    Stack<Iterator<NestedInteger>> stack = new Stack<>();
    Integer cache = null;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        if(!nestedList.isEmpty()){
            stack.push(nestedList.iterator());
            refresh();
        }
    }

    @Override
    public Integer next() {
        Integer res = cache;
        refresh();
        return res;
    }
    
    private void refresh(){
        cache = null;
        while(!stack.isEmpty()){
            Iterator<NestedInteger> topIter = stack.peek();
            if(topIter.hasNext()){
                NestedInteger ni = topIter.next();
                if(ni.isInteger()){
                    cache = ni.getInteger();
                    break;
                }else{
                    stack.push(ni.getList().iterator());
                }
            }else{
                stack.pop();
            }
        }
    }

    @Override
    public boolean hasNext() {
        return cache!=null;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
