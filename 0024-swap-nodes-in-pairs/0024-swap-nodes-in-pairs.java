/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;

        ListNode previous = new ListNode(0, head);
        ListNode returnNextNode = previous;
        ListNode current = previous.next;
        ListNode toSwap = current.next;
            
        while (toSwap != null) {
            current.next = toSwap.next;
            toSwap.next = current;
            previous.next = toSwap;
            
            previous = current;
            current = previous.next;
            toSwap = current == null ? null : current.next;
        }
        return returnNextNode.next;
    }
}