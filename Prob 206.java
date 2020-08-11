/*
206. Reverse Linked List
Reverse a singly linked list.
Example:
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:
A linked list can be reversed either iteratively or recursively. Could you implement both?
*/
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
    ListNode front = null,curr = null, prev1 = null;
    public ListNode reverseList(ListNode head) {
        /*ListNode prev = null,curr = head,front = head;
        while(front != null){
            front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;                
        }
        return prev; 
        */
        return recur(null,head);
    }
    private ListNode recur(ListNode prev,ListNode head){
        if(head == null)
            return prev;
        front = head.next;
        head.next = prev;
       return recur(head,front);
    }
}