import sys
from collections import deque


n = int(sys.stdin.readline())
q = deque([])
for _ in range(n):
    cmd = sys.stdin.readline()
    if cmd.startswith("push"):
        q.append(int(cmd.split(" ")[1]))
    elif cmd.startswith('front'):
        if q:
            print(q[0])
        else:
            print(-1)
    elif cmd.startswith('back'):
        if q:
            print(q[-1])
        else:
            print(-1)
    elif cmd.startswith('pop'):
        if q:
            print(q.popleft())
        else:
            print(-1)
    elif cmd.startswith('empty'):
        if q:
            print(0)
        else:
            print(1)
    elif cmd.startswith('size'):
        print(len(q))