"""
ADD TWO NUMBERS
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
"""
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        carry = 0;
        sum_val = 0;
        head = tail = None
        while (l1 is not None or l2 is not None):
            temp = ListNode(0);
            if(l1 is None):
                sum_val = l2.val + carry
                l2 = l2.next
            elif(l2 is None):
                sum_val = l1.val + carry
                l1 = l1.next
            else:
                sum_val = l1.val + l2.val + carry
                l1 = l1.next
                l2 = l2.next
           
            carry = int(sum_val / 10)
            temp.val = (sum_val % 10)
            if(head is None):
                tail = temp
                head = temp
            else:
                tail.next = temp;
                tail = temp;
        if(carry > 0):
            temp = ListNode(carry)
            tail.next = temp;
        return head
        
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        
        result = current = ListNode(0)
        carry = 0
        
        while l1 or l2 or carry:
            if l1:
                carry += l1.val
                l1 = l1.next
            if l2:
                carry += l2.val
                l2 = l2. next            
            current.next = ListNode(carry%10)
            current = current.next
            carry = carry // 10           
        return result.next
"""