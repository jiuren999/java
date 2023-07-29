import javax.swing.plaf.multi.MultiSeparatorUI;
import java.util.prefs.NodeChangeEvent;

public class HashBucket {

    public class Node{
        public int key;
        public int value;
        public Node next;

        public Node(int key ,int value){
            this.key = key;
            this.value = value;
        }
    }


    public Node[] array;
    private int size;

    private static final double LOAD_FACTOR = 0.75;
    private static final int DEFAULT_SIZE = 8;//默认桶的大小

    public void put(int key,int value){
        int Index = key%array.length;
        Node cur = array[Index];
        while (cur != null){
            if (cur.key == key){
                cur.value = value;
                return;
            }
            cur = cur.next;
        }
        Node node = new Node(key,value);
        node.next = array[Index];
        array[Index] = node;
        size++;
        if (loadFactor()>LOAD_FACTOR){
            resize();
        }
    }

    private double loadFactor() {
        return size * 1.0 / array.length;
    }

    private void resize(){
        Node[] newArray = new Node[2*array.length];
        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            while (cur != null){
                int index = cur.key%array.length;
                Node curNext = cur.next;
                cur.next = newArray[index];
                newArray[index] = cur;
                cur = curNext;
            }
        }
        array = newArray;
    }

    private int get(int key){
        int index = key%array.length;
        Node cur = array[index];
        while (cur != null){
            if (cur.key == key){
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;
    }
    public HashBucket(){

    }


}
