package linkedlist;

import util.ListNode;
import util.ListUtil;

public class T206_reverseList {
    public ListNode reverseList (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        pre.next = null;
        while (cur != null) {
            ListNode temp = cur.next; //注意，此处需要保存的是cur.next 的指针
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.initList();
        ListUtil.printList(head);
        head = new T206_reverseList().reverseList(head);
        ListUtil.printList(head);
    }
}
