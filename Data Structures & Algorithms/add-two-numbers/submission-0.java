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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        int carryover = 0;

        ListNode dummy = new ListNode(0);
        ListNode l3 = dummy; 

        while(l1 != null || l2 != null || carryover != 0){
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            int curr = x + y + carryover;

            int digit = curr % 10; 
            carryover = curr / 10;

            l3.next = new ListNode(digit);
            l3 = l3.next;

            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;

        }

        return dummy.next;

    }
}
