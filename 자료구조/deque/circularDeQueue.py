class Node:
    def __init__(self, val=0, prev=None, next=None):
        self.val = val
        self.prev = prev
        self.next = next


class CircularDeQueue:
    def __init__(self):
        self.head = Node()
        self.tail = Node()
        self.head.next, self.tail.prev = self.tail, self.head

    def insertFront(self, val):
        node = Node(val, prev=self.head, next=self.head.next)

        n = self.head.next
        self.head.next = n.prev = node

    def insertLast(self, val):
        node = Node(val, prev=self.tail.prev, next=self.tail)
        p = self.tail.prev
        p.next = node
        self.tail.prev = node

    def getFront(self):
        if self.head.next != self.tail:
            return self.head.next.val
        return -1

    def getLast(self):
        if self.tail.prev != self.head:
            return self.tail.prev.val
        return -1

    def delFront(self) -> bool:
        if self.head.next == self.tail:
            return False

        p = self.head.next
        self.head.next, p.prev = p.next, self.head
        return True

    def delLast(self) -> bool:
        if self.tail.prev == self.head:
            return False

        p = self.tail.prev

        self.tail.prev, p.next = p.prev, self.tail
        return True

    def isEmpty(self) -> bool:
        return self.head.next == self.tail



q = CircularDeQueue()

q.insertFront(1)
q.insertFront(2)
q.insertFront(3)

print(q.getFront())
print(q.getLast())

q.insertLast(5)
print(q.getLast())
print(q.delLast())
print(q.getLast())
print(q.delFront())
print(q.getFront())
