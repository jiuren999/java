public class test {

    static class ListNode{
        public int val;
        public ListNode next;

        ListNode(int val) {
            this.val=val;
        }
    }
    public ListNode head;

        public boolean chkPalindrome(ListNode head) {

            if (head==null){
                return false;
            }
            if (head.next==null){
                return true;
            }
            ListNode prev = head;
            ListNode slow = head;

            while (slow!=null && slow.next!=null){
                prev=prev.next;
                slow=slow.next.next;

            }
            ListNode cur = prev.next;
            while (cur!=null){
                ListNode curNext = cur.next;
                cur.next = prev;
                prev = cur;
                cur = curNext;
            }
            while (prev!=head ){
                if (head.val != prev.val){
                    return false;
                }
                if (head.next == prev){
                    return true;
                }
                prev = prev.next;
                head = head.next;
            }
            return true;
        }

    }


