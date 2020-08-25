package util;

import java.util.Scanner;

public class ListUtil {
    public static ListNode initList () {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 5 ; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return head;
    }
    public static ListNode initListFromScanner () {
        Scanner sc = new Scanner(System.in);
        ListNode head = new ListNode(sc.nextInt());
        ListNode cur = head;
        while (sc.hasNext()) {
            cur.next = new ListNode(sc.nextInt());
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }

    public static void printList (ListNode head) {
        ListNode cur = head;
        if (cur == null) {
            return;
        }
        while (cur.next != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println(cur.val);
    }

}
