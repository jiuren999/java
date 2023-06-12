class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minstack;
    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minstack.empty()){
            minstack.push(val);
        }else {
            if(val <= minstack.peek()) {
                minstack.push(val);
            }
        }
    }

    public void pop() {
        if (!stack.empty()){
            Integer i = stack.pop();
            if(i.equals(minstack.peek())){
                minstack.pop();
            }
        }
    }

    public int top() {
        if(!stack.empty()){
            return stack.peek();
        }
        return -1;

    }

    public int getMin() {
        return minstack.peek();
    }
}