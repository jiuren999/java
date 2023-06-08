import java.util.Stack;

public class test {


    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String x : tokens) {
            if (!isOperation(x)) {
                stack.push(Integer.parseInt(x));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (x) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                }
            }
        }
        return stack.pop();

    }

    private boolean isOperation(String x) {
        if (x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/")) {
            return true;
        }
        return false;
    }


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '{' ||s.charAt(i) =='(' ){
                stack.push(s.charAt(i));
            }else {
                if (stack.empty()){
                    return false;
                }
                char ch = stack.peek();
                if (ch == '(' && s.charAt(i)==')' || ch == '{' && s.charAt(i)=='}'|| ch == '[' && s.charAt(i)==']'){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        if (!stack.empty()){
            return false;
        }
        return true;
    }

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (j<pushA.length || !stack.empty() ||stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }


    class MyCircularQueue1 {
        int[] elem;
        int front;
        int rear;

        public MyCircularQueue1(int k) {
            this.elem = new int[k];
        }

        public boolean enQueue(int value) {
            if (isFull()){
                return false;
            }
                elem[rear] = value;
            rear = (rear+1)%elem.length;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()){
                return false;
            }
            front = (front+1)%elem.length;
            return true;
        }

        public int Front() {
            if (isEmpty()){
                return -1;
            }
            return elem[front];
        }

        public int Rear() {
            if (isEmpty()){
                return -1;
            }
            int dex = (rear == 0)?elem.length-1:rear-1;
            return elem[dex];
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public boolean isFull() {
            if ((rear+1)%elem.length == front){
                return true;
            }
            return false;
        }
    }



    class MyCircularQueue {
        int[] elem;
        int front;
        int rear;
        public MyCircularQueue(int k) {

            this.elem = new int[k+1];
        }

        public boolean enQueue(int value) {
            if (isFull()){
                return false;
            }
            elem[rear] = value;
           rear=(rear+1)%elem.length;
           return true;
        }

        public boolean deQueue() {
            if (isEmpty()){
                return false;
            }
            front=(front+1)%elem.length;
            return true;
        }

        public int Front() {
            if (isEmpty()){
                return -1;
            }
            return elem[front];
        }

        public int Rear() {
            if (isEmpty()){
                return -1;
            }
            int inx = (rear==0)?elem.length-1:rear-1;
            return elem[inx];
        }

        public boolean isEmpty() {
            return front==rear;
        }

        public boolean isFull() {
            if ((rear+1)%elem.length==front){
                return true;
            }
            return false;
        }
    }

}

