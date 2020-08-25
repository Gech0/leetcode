package tree;

import util.ListNode;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T109_sortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        List<Integer> list = linkToArr(head);
        return sortedListToBST(list, 0, list.size() - 1);
    }

    private TreeNode sortedListToBST(List<Integer> list, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        int val = list.get(mid);
        TreeNode root = new TreeNode(val);
        root.left = sortedListToBST(list, left, mid - 1);
        root.right = sortedListToBST(list, mid + 1, right);
        return root;
    }

    private List<Integer> linkToArr(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }
}
