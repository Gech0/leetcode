import util.ListNode;
import util.ListUtil;

public class T24_swapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        ListNode temp = cur.next;
        cur.next = head;
        head.next = swapPairs(temp);
        return cur;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.initList();
        head = new T24_swapPairs().swapPairs(head);
        ListUtil.printList(head);
    }
}
