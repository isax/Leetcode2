class MinStack {
    
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    
    public void push(int x) {
        stack.push(x);
        
        if(minStack.isEmpty()|| minStack.peek()>=x){
            minStack.push(x);
        }
    }

    public void pop() {
        int i = stack.pop();
        
        if(minStack.peek()==i){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
