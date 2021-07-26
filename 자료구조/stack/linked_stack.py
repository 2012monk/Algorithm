class Node:
    def __init__(self, val, next):
        self.next = next
        self.val = val

class Stack:
    def __init__(self):
        self.top = None
        self.length = 0

    def push(self, val):
        self.top = Node(val, self.top)
        self.length += 1

    def pop(self) -> int:
        t = self.top
        self.top = self.top.next
        self.length -= 1
        return t.val

    def size(self) -> int:
        return self.length


stack = Stack()

stack.push(1)
stack.push(2)
stack.push(3)

print(stack.size())

print(stack.pop())
print(stack.pop())