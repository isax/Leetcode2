class MyStack {
    // Reference: http://www.geeksforgeeks.org/implement-stack-using-queue/
    private LinkedList<Integer> queue1 = new LinkedList<Integer>();
    private LinkedList<Integer> queue2 = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push2(int x) {
        queue1.add(x);
    }
    public void push(int x) {
        queue2.add(x);
        
        while(!queue1.isEmpty()){
            queue2.add(queue1.pop());
        }
        
        LinkedList<Integer> queue = queue1;
        queue1 = queue2;
        queue2 = queue;
    }


    // Removes the element on top of the stack.
    public void pop2() {
        while(queue1.size()>1){
            queue2.add(queue1.pop());
        }
        queue1.pop();
        
        LinkedList<Integer> queue = queue1;
        queue1 = queue2;
        queue2 = queue;
    }
    
    public void pop() {
        queue1.pop();
    }

    // Get the top element.
    public int top2() {
        while(queue1.size()>1){
            queue2.add(queue1.pop());
        }
        int temp = queue1.pop();
        queue2.add(temp);
        
        LinkedList<Integer> queue = queue1;
        queue1 = queue2;
        queue2 = queue;
        return temp;
    }
    
    public int top() {
        return queue1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty();
    }
}
