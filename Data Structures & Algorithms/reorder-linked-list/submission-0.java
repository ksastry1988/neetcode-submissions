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
    public void reorderList(ListNode head) {
        if(head == null) return;
 
        ListNode slow = head; 
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next; 
        }

        ListNode list2 = slow.next; 
        slow.next = null;

        ListNode prev = null;;

        while(list2 != null){
            ListNode next = list2.next;
            list2.next = prev;
            prev = list2;
            list2 = next;
        }

        ListNode first = head;
        ListNode second = prev;

        while (first != null && second != null){
            ListNode firstNode = first.next;
            ListNode secondNode = second.next; 

            first.next = second;
            second.next = firstNode; 
            
            first = firstNode;
            second = secondNode; 
        }
    }
}
