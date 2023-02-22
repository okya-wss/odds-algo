package algo.list;

import structure.ListNode;

/**
 * K 个一组翻转链表 25
 *
 * @author shuaishuai.wang
 * @date 2022-02-24
 **/


public class ReverseNodesInKGroup_25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }


    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode cur = head;
        while (prev != tail) {
            ListNode nex = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nex;
        }
        return new ListNode[]{tail, head};
    }


    public ListNode reverseKGroupReview(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }
}

