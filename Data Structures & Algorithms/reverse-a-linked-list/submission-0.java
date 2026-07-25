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
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode next = curr.next; // Step 1
            curr.next = prev;          // Step 2 (reverse)
            prev = curr;               // Step 3
            curr = next;               // Step 4
        }

        return prev;
    }
}
