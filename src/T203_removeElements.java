import util.ListNode;
import util.ListUtil;

public class T203_removeElements {

    /*
    注意：需要注意,
    1、删除的元素是 第一个，或最后一个
    2、编写注意: 开头是连续的val，中间有连续的val
     */

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode l = head;
        while (l != null && l.next != null) {
            ListNode temp = l.next;
            while (temp != null && temp.val == val) {
                temp = temp.next;
            }
            l.next = temp;
            l = l.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.initListFromScanner();
        ListUtil.printList(head);
        head = new T203_removeElements().removeElements(head, 1);
        ListUtil.printList(head);

    }
}
