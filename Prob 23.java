/*
23. Merge k Sorted Lists
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
Example:
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
        return null;
        PriorityQueue <Integer> minheap = new PriorityQueue<>();
        for(int i = 0;i < lists.length;i++){
            ListNode ptr = lists[i];
            while(ptr != null){
                minheap.add(ptr.val);
                ptr = ptr.next; 
            }
        }
        if( minheap.isEmpty() )    return null;
        ListNode head = new ListNode(minheap.poll());
        ListNode ptr = head;
        while(!minheap.isEmpty()){
            ptr.next = new ListNode(minheap.poll());
            ptr = ptr.next;
        }
        return head;        
    }
}