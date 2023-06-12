import java.util.List;
public class MyStackForLinkedList {
    // 先创建一个链表
    class Node{

        public int val;
        public Node next;

        public Node(int val){
            this.val = val;
        }
    }
    private Node head = null;
    public void push(int val) {
        Node newNode = new Node(val);
        // 特殊情况的处理，空链表
        if (head == null) {
            head = newNode;
            return;
        }
        // 处理一般情况
        newNode.next = head;
        head = newNode;
    }

    public Integer pop() {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            int ret = head.val;
            head = null;
            return ret;
        }
        int ret = head.val;
        head = head.next;
        return ret;
    }

    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.val;
    }
}