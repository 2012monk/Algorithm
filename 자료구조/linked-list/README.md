### LinkedList 연결리스트

---

> 연결리스트는 각 노드 들이 서로 연결을 통해 구현되어있는 형태의 리스트, 선형자료구
> 
> > Node _마디, 교점_ Vertext _정점,꼭지점_
> 
> 
> Array List 와 다르게 하나의 데이터의 저장이 연속적인 메모리공에 늘어선것이 아니라
> 
> 각 노드의 다음 주소값으로 서로 연결되어있다.
> 
> 불연속적인 메모리공간에 흩뿌려진 형태
> 
> 
![](./Linkedlist.png)
[geekforgeeks](https://www.geeksforgeeks.org/data-structures/linked-list/)


#### 연결리스트 탐색,삽입, 삭제

- 탐색 O(n)

    배열과 달리 특정 인덱스에 접근하기위해서 전체를 순서대로 읽어 나가야한다

    k 번째 노드에 접근하기 위해서 O(k)

- 삽입, 삭제 O(1)

    시작지점 또는 끝지점에서 삽입 삭제는 상수시간에 가능하다
    
    k번째 노드에서 삽입 삭제는 O(k) -> O(n)


장점

- 자료의 삽입, 삭제가 용이하다
- 연속적인 메모리 할당이 필요하지 않다 _메모리 공간 한계만큼 늘릴수 있다_
- 

단점

- 포인터의 사용으로 메모리공간이 많이 사용됨
- 탐색시 시간이 오래걸린다


### 구현


python 으로 구현한 single linked list

python 은 list 가 기본적으로 linked list 를 지원한다

전체코드는 [github](./linked_list.py) 에 있습니다
```python
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


    def remove(self, index) -> None:
        self.__check(index)
        if index == 0:
            self.head = self.head.next
        else:
            cur = self.move(index - 1)
            cur.next = cur.next.next

        self.length -= 1
    
    # N 번 다음 노드로 진행
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

```

TEST 코드

```python

# setup
li = LinkedList()

li.add_back(1)
li.add_back(2)
li.add_back(3)

li.print_all()  # 1, 2, 3

li.add(1, 4) # index 1번에 노드 삽입

li.print_all()  # 1, 4, 2, 3
print(li.size()) # size = 4

li.remove(2)  # 2번 삭제
print(li.get(2))  # 2번 value=3
li.print_all()  # 1, 4, 3
```