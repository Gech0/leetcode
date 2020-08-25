package linkedlist;

import util.ListNode;

public class T19_removeNthFromEnd {
    /*
    input : [1]  ==> output : []
    要删除的元素是链表头！要注意
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preN = head;
        ListNode post = head;
        for (int i = 0; preN != null && i < n; i++) {
            preN = preN.next;
        }
        if (preN == null) return head;
        while (preN.next != null) {
            preN = preN.next;
            post = post.next;
        }
        post.next = post.next.next;
        return head;
    }
}
