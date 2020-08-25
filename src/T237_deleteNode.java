import util.ListNode;

public class T237_deleteNode {

    /*
    这道题的意思是删除传入的该节点。
    因为不能获取到之前的节点，故不能删除该节点，题目中说此节点不可能是最后一个节点，
    故，可以用当前节点来表示下一个节点的值，删除下一个节点
     */

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
