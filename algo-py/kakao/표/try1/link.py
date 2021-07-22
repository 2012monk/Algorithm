class node:
    def __init__(self, value, prev, nextNode):
        self.value = value
        self.prev = prev
        self.next = nextNode



def solution(n, p, cmd):
    head = node(0, None, None)

    for i in range(n):
        head.next = node(i, head, None)
        head = head.next


n = 10
head = node(0, None, None)

for i in range(n):
    head.next = node(i, head, None)
    head = head.next

while head.prev is not None:
    print(head.value)
    head = head.prev
