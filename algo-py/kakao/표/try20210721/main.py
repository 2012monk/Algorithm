from collections import deque


def solution(n, k, cmd):
    stk = []
    l, r = deque([i for i in range(k + 1)]), deque([i for i in range(k + 1, n)])
    res = ['O' for i in range(n)]
    for c in cmd:
        if c.startswith('D'):
            k = int(c.split()[1])
            for i in range(k):
                if not r:
                    break
                l.append(r.popleft())
        if c.startswith('U'):
            k = int(c.split()[1])
            for i in range(k):
                if not len(l) > 1:
                    break
                r.appendleft(l.pop())
        if c == 'C':
            stk.append((l.pop(), len(l) if l else 0))
            res[stk[-1][1]] = 'X'
            if r:
                l.append(r.popleft())

        if c == 'Z':
            if not stk:
                continue
            m = stk.pop()
            res[m[1]] = 'O'
            if m[1] < len(l) - 1:
                l.insert(m[1], m[0])
            else:
                r.insert(m[1] - len(l), m[0])

    return "".join(res)


import time

n = 12
k = 2
# cmd = ["D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"]
# cmd = ["U 5", "C", "D 2", "Z"]
cmd = ["C", "U 4", "C", "D 3", "C", "D 2", "Z"]
cmd = ["D 6", "C", "C", "C"]
# cmd = ["D 100000", "C", "C", "U 80000", "C", "D 1000000", "Z", "Z"]

st = time.time()
print(solution(n, k, cmd))
print(time.time() - st, "ms")
