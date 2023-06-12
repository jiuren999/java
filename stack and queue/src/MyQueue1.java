public class MyQueue1 {

     class Node {
        public int val;
        public Node next;

        public Node(int val){
            this.val = val;
        }
    }
     public Node front;
     public Node rear;
     public int usedSize;

    public void offer(int val){
        Node node = new Node(val);
        if (front==null){
            front = node;
            rear = node;
        }else {
            rear.next = node;
            rear = rear.next;
        }
        usedSize++;

    }

    public int poll(){
        if (isEmpty()) {
            return -1;
        }
        int ret = front.val;
        front = front.next;
        if (front == null){
            rear = null;
        }
        usedSize--;
        return ret;

    }
    public int peek(){
        if(front == null){
            return -1;
        }
        return front.val;
    }
    public boolean isEmpty(){
        return usedSize==0;
    }

}
