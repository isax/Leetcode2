class MyStack {
    // https://leetcode.com/discuss/39814/concise-1-queue-java-c-python
    Queue <Integer> q = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        q.offer(x);
        for(int i = 0; i<q.size()-1; i++){
            q.offer(q.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.poll();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
    
    /* Mine:... not good
    Queue <Integer> q1 = new LinkedList<Integer>();
    Queue <Integer> q2 = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        q1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        popQ1();
        if(!q1.isEmpty()) q1.poll();
        Queue <Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Get the top element.
    public int top() {
        popQ1();
        if(!q1.isEmpty()){
            int i = q1.peek();
            q1.poll();
            q2.offer(i);
            Queue <Integer> temp = q1;
            q1 = q2;
            q2 = temp;
            return i;
        }else{
            return -1;
        }
    }
    
    private void popQ1(){
        while(q1.size()>1){
            int i = q1.poll();
            q2.offer(i);
        }
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }*/
}
