class Node:
    def __init__(self, value):
        self.value = value
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = None
        self.length = 0

    def add(self, index, val) -> None:
        if self.length == 0 or index == 0:
            self.add_front(val)
        elif self.length <= index:
            self.add_back(val)
        else:
            # index - 1 번째 노드까지 탐색후 새로운 노드 연결
            cur = self.head
            for _ in range(index - 1):
                cur = cur.next
            node = Node(val)
            node.next, cur.next = cur.next, node
            self.length += 1

    # 마지막에 추가 O(n)
    def add_back(self, val):
        if self.length == 0:
            self.head = Node(val)
        else:
            cur = self.move(self.length - 1)
            cur.next = Node(val)
        self.length += 1

    # 첫번째에 추가 O(1)
    def add_front(self, val):
        if self.length == 0:
            self.head = Node(val)
        else:
            node = Node(val)
            node.next = self.head
            self.head = node
        self.length += 1

    def remove(self, index) -> None:
        self.__check(index)
        if index == 0:
            self.head = self.head.next
        else:
            cur = self.move(index - 1)
            cur.next = cur.next.next

        self.length -= 1

    def move(self, index) -> Node:
        self.__check(index)
        cur = self.head
        for _ in range(index):
            cur = cur.next
        return cur

    def get(self, index) -> int:
        return self.move(index).value

    def print_all(self) -> None:
        c = self.head
        while c is not None:
            print(c.value, end=', ')
            c = c.next
        print()



    def size(self) -> int:
        return self.length

    def is_empty(self) -> bool:
        return self.head.next is None

    def __check(self, index):
        if self.length == 0:
            raise Exception('리스트가 비어있습니다')
        if index >= self.length:
            raise Exception('index out of bound')


# setup
li = LinkedList()

li.add_back(1)
li.add_back(2)
li.add_back(3)

li.print_all()  # 1, 2, 3

li.add(1, 4)

li.print_all()  # 1, 4, 2, 3
print(li.size())

li.remove(2)  # 2번 삭제
print(li.get(2))  # 2번 value=3
li.print_all()  # 1, 4, 3
