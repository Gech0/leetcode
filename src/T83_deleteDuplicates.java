import util.ListNode;
import util.ListUtil;

import java.util.HashSet;
import java.util.Scanner;

public class T83_deleteDuplicates {
    /*
    1、cur.next 之前，一定要考虑cur是不是已经为空？
    2、开头要注意输入为空的情况
    3、需要被删除的节点连续
     */
    /*
    注：
    1、给出的是排序数组，所以可以通过比较大小来判定有没有出现，不需要开辟set。
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        HashSet<Integer> set = new HashSet<>();
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null) {
            set.add(pre.val);
            while (cur != null && set.contains(cur.val)) {
               cur = cur.next;
            }
            pre.next =cur;
            pre = pre.next;
            if (pre == null) break;
            cur = pre.next;
        }
        return head;
    }


    public ListNode deleteDuplicates_II(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates_recursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates_recursion(head.next);
        if (head.val == head.next.val) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode head = ListUtil.initListFromScanner();
//        head = new T83_deleteDuplicates().deleteDuplicates(head);
        head = new T83_deleteDuplicates().deleteDuplicates_recursion(head);
        ListUtil.printList(head);
    }

}
