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
        if(lists == null) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode list : lists){
            if(list!=null){
                queue.add(list);
            }
        }

        ListNode result = new ListNode(0);
        ListNode tail = result; 

        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            tail.next = node;
            tail = tail.next;

            ListNode next = node.next;

            if(next != null){
                queue.add(next);
            }
        }
        return result.next; 
    }
}
