"""
    효율성 결과
    테스트 1 〉	통과 (1401.21ms, 216MB)
    테스트 2 〉	통과 (1301.55ms, 216MB)
    테스트 3 〉	통과 (1284.72ms, 216MB)
    테스트 4 〉	통과 (1404.34ms, 223MB)
    테스트 5 〉	통과 (1292.49ms, 223MB)
    테스트 6 〉	통과 (1319.83ms, 221MB)
    테스트 7 〉	통과 (308.35ms, 57.5MB)
    테스트 8 〉	통과 (362.95ms, 71.1MB)
    테스트 9 〉	통과 (1279.28ms, 223MB)
    테스트 10 〉	통과 (1361.50ms, 223MB)
"""


class Node:
    def __init__(self, value):
        self.value = value
        self.prev = None
        self.next = None


def solution(n, k, cmds):
    st = []
    l = [Node(i) for i in range(n)]
    for i in range(1, n - 1):
        l[i].prev = l[i - 1]
        l[i].next = l[i + 1]

        l[i - 1].next = l[i + 1].prev = l[i]

    cur = l[k]
    for c in cmds:
        print(c)
        if c.startswith('U'):
            for _ in range(int(c.split(' ')[1])):
                cur = cur.prev
        elif c.startswith('D'):
            for _ in range(int(c.split(' ')[1])):
                cur = cur.next
        elif c == 'C':
            st.append(cur)
            pv = cur.prev
            nx = cur.next
            if pv:
                pv.next = nx

            if nx is None:
                cur = pv
            else:
                cur = nx
                nx.prev = pv

        else:
            node = st.pop()

            if node.prev:
                node.prev.next = node
            if node.next:
                node.next.prev = node
    res = ['O' for i in range(n)]
    while st:
        res[st.pop().value] = 'X'

    return ''.join(res)


n = 8
k = 2
# cmd = ["D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"]
# cmd = ["U 5", "C", "D 2", "Z", "C"]
# cmd = ["C", "U 4", "C", "D 3", "C", "D 2", "Z"]
# cmd = ["U 1", "C", "C", "C", 'D 1', 'Z']
cmd = ["D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"]

print(solution(n, k, cmd))
