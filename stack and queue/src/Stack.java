import java.util.Arrays;
import java.util.Stack;

public class Stack {
    public int[] elem;
    public int usedSize;

    public Stack(){
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
}


