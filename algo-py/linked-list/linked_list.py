class Node:
    def __init__(self, value):
        self.value = value
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = Node(None)

    def add(self, val):
        c = self.head
        while c.next is not None:
            c = c.next
        c.next = Node(val)

    def remove(self, val):
        c = self.head
        while c.next is not None:
            if c.next.value == val:
                nxt = c.next.next
                c.next = nxt
                break

    def print_all(self):
        c = self.head
        while c.next is not None:
            print(c.next.value)
            c = c.next

    def size(self):
        s = 0
        c = self.head.next
        while c is not None:
            s += 1
            c = c.next
        print("size is ", s)

    def is_empty(self):
        return self.head.next is None





li = LinkedList()

li.add(2)
li.add(3)
li.add(5)

li.print_all()
li.size()

li.remove(2)
li.add(54)

li.print_all()
