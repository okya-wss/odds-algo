package algo;

import structure.ListNode;

/**
 * // 206 reverse-linked-list	反转链表
 *
 * @author shuaishuai.wang
 * @date 2021-03-04
 **/
public class ReverseLinkedList_206 {

    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
