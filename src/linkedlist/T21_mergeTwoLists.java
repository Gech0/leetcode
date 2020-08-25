package linkedlist;

import util.ListNode;

public class T21_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode r = l;
        while ( p !=null && q != null) {
            if (p.val < q.val) {
                r.next = new ListNode(p.val);
                p = p.next;
            } else {
                r.next = new ListNode(q.val);
                q = q.next;
            }
            r = r.next;
        }
        while (p != null) {
            r.next = new ListNode(p.val);
            p = p.next;
            r = r.next;
        }
        while (q != null) {
            r.next = new ListNode(q.val);
            q = q.next;
            r = r.next;
        }

        return l.next;
    }


    public ListNode mergeTwoLists_recursion (ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists_recursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists_recursion(l1, l2.next);
            return l2;

        }

    }
}
