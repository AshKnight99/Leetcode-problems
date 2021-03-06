/*
92. Reverse Linked List II
Reverse a linked list from position m to n. Do it in one-pass.
Note: 1 ? m ? n ? length of list.
Example:
Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || n <= m){
            return head;
        }       
        int count = 1;
        ListNode temp = head;
        ListNode node = head;
        while(temp != null){
            if(count == m){
                ListNode prev = null;
                ListNode n1 = temp;
                while(count <= n && temp != null){
                    ListNode dummy = temp.next;
                    temp.next = prev;
                    prev = temp;
                    temp = dummy;
                    count += 1;
                }
                
                node.next = prev;
                n1.next = temp;
                if(m == 1){
                    head = prev;
                }
                break;
            }
            node = temp;
            count += 1;
            temp = temp.next;
        }
        return head;
    }
}