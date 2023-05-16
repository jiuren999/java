public class MainList1 {

    class Node{
       public int date;
       public Node next;

       public Node(int date){
           this.date = date;
       }
    }
     public Node head;

    //得到单链表的长度
    public int size(){
        int count = 0;
        Node cur = head;
        while (cur!= null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    public void creatLink(){
        Node node1 = new Node(12);
        Node node2 = new Node(45);
        Node node3 = new Node(23);
        Node node4 = new Node(90);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        head = node1;
    }
    public void display(){
        Node cur = head;
        while (cur != null){
            System.out.print(cur.date+" ");
            cur = cur.next;
        }
        System.out.println( );
    }

    //头插法
    public void addFirst(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;
    }
    //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        if (head == null){
            head = node;
            return;
        }
        Node cur = head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data) throws IndexOutOfExciption{
        cheakIndex(index);
        if (index==0){   //此时可以引用头插
            addFirst(data);
            return;
        }
        if (index==size()){  // 此时可以引用尾插
            addLast(data);
            return;
        }
        Node node = new Node(data);
        Node cur = findIndexSub0ne(index);
        node.next = cur.next;
        cur.next=node;

    }
    //查找要插入位置的前一个节点
    private Node findIndexSub0ne(int index){
        int count = 0;
        Node cur = head;
        while (count != index-1){
            cur = cur.next;
            count++;
        }

        return cur;
    }
    private void cheakIndex(int index){  //检查Index合法不合法
        if (index < 0 || index > size()){
            throw new IndexOutOfExciption("index位置不合法");
        }
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if (head==null){
            return;
        }
        if (head.date == key){
            head = head.next;
            return;
        }
        Node cur = searchPro(key);
        if (cur==null){
            return;
        }
        cur.next = cur.next.next;
    }
    /////////////找到key的前一个节点
    private Node searchPro(int key){
        Node cur = head;
        while (cur.next !=null){
            if (cur.next.date == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        if (head==null){
            return;
        }
        Node cur = head.next;
        Node prev = head;
        while (cur != null) {
            if (cur.date == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (head.date==key){
            head=head.next;
        }
    }
    public void clear() {
        head=null;
    }
}
