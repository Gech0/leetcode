package linkedlist;

import util.ListNode;
import util.ListUtil;

public class T2_addTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = ListUtil.initListFromScanner();
        T2_addTwoNumbers t = new T2_addTwoNumbers();
        ListUtil.printList(t.addTwoNumbers_plus(l1,l2));
    }

    /*
    可以应付一般的两数相加，大数会导致溢出
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long n1 = getVal(l1);
        long n2 = getVal(l2);
        long sum = n1 + n2;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        if (sum == 0) {
            return head;
        }
        while (sum != 0) {
            cur.next = new ListNode((int) (sum % 10));
            sum /= 10;
            cur = cur.next;
        }
        return head.next;
    }

    private long getVal (ListNode l) {
        long val = 0;
        for (int i = 0; l != null; l = l.next,i++) {
            val += l.val * Math.pow(10, i);
        }
        return val;
    }


    /*
    模拟手工加法
     */
    public ListNode addTwoNumbers_plus(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(carry % 10);
            carry /= 10;
            cur = cur.next;
        }
        return head.next;
    }
}
