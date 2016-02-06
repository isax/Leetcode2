class MinStack {
    Stack<Integer> min = new Stack<Integer>();
    Stack<Integer> stack = new Stack<Integer>();
    
    public void push(int x) {
        if(stack.isEmpty() || min.peek()>=x){
            min.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if(!stack.isEmpty()){
            int i = stack.pop();
            if(i==min.peek()){
                min.pop();
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
