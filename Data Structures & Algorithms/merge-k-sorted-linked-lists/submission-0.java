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
    public ListNode mergeKLists(ListNode[] lists) {

        // Min heap based on node value
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        // Step 1: Add first node of each list
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        // Dummy node to build result
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Step 2: Process heap
        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();

            tail.next = smallest;
            tail = tail.next;

            // If next node exists, add to heap
            if (smallest.next != null) {
                pq.add(smallest.next);
            }
        }

        return dummy.next;
    }
}
