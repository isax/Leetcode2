class MyQueue {
    Stack<Integer> cache = new Stack<Integer>();
    Stack<Integer> storage = new Stack<Integer>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        storage.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(empty()) return;
        
        if(cache.isEmpty()){
            while(!storage.isEmpty()){
                cache.push(storage.pop());
            }
        }
        cache.pop();
    }

    // Get the front element.
    public int peek() {
        if(empty()) return -1;
        
        if(cache.isEmpty()){
            while(!storage.isEmpty()){
                cache.push(storage.pop());
            }
        }
        return cache.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return cache.isEmpty() && storage.isEmpty();
    }
}
