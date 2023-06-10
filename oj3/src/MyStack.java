import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> qu1;
    private Queue<Integer> qu2;

    public MyStack() {
        qu1 = new LinkedList<Integer>();
        qu2 = new LinkedList<Integer>();
    }

    public void push(int x) {
        if (!qu1.isEmpty()){
            qu1.offer(x);
        }else if (!qu2.isEmpty()){
            qu2.offer(x);
        }else {
            qu1.offer(x);
        }
    }

    public int pop() {
        if (empty()){
            return -1;
        }
        if (!qu1.isEmpty()){
            int size = qu1.size();
            for (int i = 0; i <size-1; i++) {
                int val = qu1.poll();
                qu2.offer(val);
            }
            return qu1.poll();
        }else {
            int size = qu2.size();
            for (int i = 0; i <size-1 ; i++) {
                int val = qu2.poll();
                qu1.offer(val);
            }
            return qu2.poll();
        }
    }

    public int top() {
        if (empty()){
            return -1;
        }
        if (!qu1.isEmpty()){
            int size = qu1.size();
            int val=0;
            for (int i = 0; i <size ; i++) {
                val = qu1.poll();
                qu2.offer(val);
            }
            return val;
        }else {
            int size = qu2.size();
            int val=0;
            for (int i = 0; i <size ; i++) {
                val = qu2.poll();
                qu1.offer(val);
            }
            return val;
        }
    }

    public boolean empty() {
        if (qu1.isEmpty() && qu2.isEmpty()){
            return true;
        }
        return false;
    }
}
