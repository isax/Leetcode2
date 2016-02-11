class MyQueue {
    Stack<Integer> cache = new Stack<Integer>();
    Stack<Integer> store = new Stack<Integer>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        cache.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(empty()) return;
        
        if(store.isEmpty()){
            while(!cache.isEmpty()){
                int i = cache.pop();
                store.push(i);
            }
        }
        store.pop();
    }

    // Get the front element.
    public int peek() {
        if(empty()) return Integer.MIN_VALUE;
        
        if(store.isEmpty()){
            while(!cache.isEmpty()){
                int i = cache.pop();
                store.push(i);
            }
        }
        return store.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return cache.isEmpty()&&store.isEmpty();
    }
}
