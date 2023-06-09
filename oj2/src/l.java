import java.text.*;
public class l {
    public boolean chkPalindrome(test.ListNode A) {
        test.ListNode head = A;
        if (head==null){
            return false;
        }
        if (head.next==null){
            return true;
        }
        test.ListNode prev = head;
        test.ListNode slow = head;

        while (slow!=null && slow.next!=null){
            prev=prev.next;
            slow=slow.next.next;

        }
        test.ListNode cur = prev.next;
        while (cur!=null){
            test.ListNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        while (prev!=head){
            if (head.val != prev.val){
                return false;
            }
            head = head.next;
            prev = prev.next;
        }
        while (head.next == prev){
            return true;
        }
        return false;
    }
}
