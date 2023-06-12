import java.util.Arrays;

public class MyQueue {
    public int[] elem;
    public int usedSize;

    public MyQueue(){
        this.elem = new int[10];
    }

    public void offer(int val){
        if (isFull()){
            elem = Arrays.copyOf(elem,2*elem.length);
        }
        elem[usedSize] = val;
        usedSize++;
    }
    public int poll(){
        if (isEmpty()){
            return -1;
        }
        int ret = elem[0];
        for (int i = 0; i <elem.length; i++) {
            elem[i]=elem[i+1];
        }
        usedSize--;
        return ret;
    }

    public int peek(){
        if (isEmpty()){
            return -1;
        }
        return elem[0];
    }
    public boolean isFull(){
        return usedSize == elem.length;
    }
    public boolean isEmpty(){
        return usedSize==0;
    }
}
