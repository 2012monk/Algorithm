from collections import deque
import random
import time


n = 2 ** 13
l = [random.randint(1, n) for _ in range(n)]
t = l.copy()
print(l)
q = deque([t[0]])
t.pop(0)

st = time.time()
for i in range(n - 1):
    j = i

    while j >= 0 and l[j] > l[j + 1]:
        l[j], l[j + 1] = l[j + 1], l[j]
        j -= 1
    # print(l)
end = time.time()
print(l)
print(end - st)

st = time.time()
buf = []
for i in t:

    while q and q[0] < i:
        buf.append(q.popleft())
    buf.append(i)
    while buf:
        q.appendleft(buf.pop())
    buf = []

end = time.time()
print(*q)
print(end - st)