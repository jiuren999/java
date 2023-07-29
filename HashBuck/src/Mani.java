import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Mani {



    public Node copyRandomList(Node head) {

        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null){
            Node node = new Node(cur.val);
            map.put(cur,node);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        Set set = new HashSet();

        for (int i = 0; i < jewels.length(); i++) {
            int ch =jewels.charAt(i);
            set.add(ch);
        }

        for (int i = 0; i < stones.length(); i++) {
            int ch = stones.charAt(i);
            if (set.contains(ch)){
                count++;
            }
        }
        return count;
    }




    public static void func(String str1,String str2){
        Set<Character> set = new HashSet();
        for (char ch:str2.toUpperCase().toCharArray()) {
            set.add(ch);
        }
        Set<Character> set2 = new HashSet();
        for (char ch:str1.toUpperCase().toCharArray()) {
            if (!set.contains(ch) && !set2.contains(ch)){
                set2.add(ch);
                System.out.print(ch);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            String b = in.nextLine();
            func(a,b);

        }
    }
}
