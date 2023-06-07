import java.util.List;

public class test {

    class ListNode{
        public int val;
        public ListNode next;

        public ListNode(int date){
            this.val = date;
        }
    }
    ListNode head;

    ///////合并链表
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode NewHead = new ListNode(0);
            ListNode cur = NewHead;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    cur.next = list1;
                    cur = cur.next;
                    list1 = list1.next;
                } else {
                    cur.next = list2;
                    cur = cur.next;
                    list2 = list2.next;
                }
            }
            if (list1 == null){
                cur.next = list2;
            }else {
                cur.next = list1;
            }
            return NewHead.next;
        }
    }
    //  反转链表
    class Solution1 {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode cur = head;

            while (cur!=null){
                ListNode next = cur.next;
                cur.next = prev;

                prev = cur;
                cur = next;
            }
            return prev;
        }
    }

    /////删除所有val  并返回头节点
    class Solution2 {
        public ListNode removeElements(ListNode head, int val) {
                if (head == null) {
                    return head;
                }
                while (head.val == val && head!=null) {
                    head = head.next;
                }
            ListNode prev = head;
                while (prev.next != null) {
                    if (prev.next.val == val) {
                        prev.next = prev.next.next;
                    } else {
                        prev = prev.next;
                    }
                }
            return head;
        }
    }

    class Solution3 {
        public ListNode middleNode(ListNode head) {
            ListNode p = head;
            ListNode q = head;
            while (q!=null && q.next!=null){
                q = q.next.next;
                p = p.next;
            }
            return p;
        }
    }
}



