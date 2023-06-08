import java.util.Arrays;
import java.util.Stack;

public class MyStack {
    public int[] elem;
    public int usedSize;

    public MyStack(){
        this.elem = new int[10];
    }

    public void push(int val){
        if (isFull()){
            elem = Arrays.copyOf(elem,2*elem.length);
        }
        elem[usedSize]=val;
        usedSize++;
    }

    public boolean isFull(){
        return usedSize == elem.length;
    }

    public int pop(){
        if (isEmpty()){
            throw new EmptyException("栈是空的!");
        }
        usedSize--;
        return elem[usedSize];
    }

    public boolean isEmpty(){
        return usedSize==0;
    }


    public int peek(){
        if (isEmpty()){
            throw new EmptyException("栈是空的!");
        }
        return elem[usedSize-1];
    }

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

}

