# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:

    def isPalindrome(self, head: ListNode) -> bool:
        rev = None
        slow = fast = head
        while fast and fast.next:
            fast = fast.next.next

            rev, rev.next, slow = slow, rev, slow.next
        if fast:  # 홀수일때 중앙값을 건너뛴다
            slow = slow.next

        while rev and rev.val == slow.val:
            slow, rev = slow.next, rev.next

        return not rev  # 비교연산후 남아있는 노드가 없으면 palindrome
