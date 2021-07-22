from collections import deque
import sys


def solution(case):
    l, r = deque([]), []
    for s in case:
        if s == '<':
            if l:
                r.append(l.pop())
        elif s == '>':
            if r:
                l.append(r.pop())
        elif s == '-':
            if l:
                l.pop()
        else:
            l.append(s)
    l.extend(r)

    return ''.join(l)

for _ in range(int(input())):
    print(solution(sys.stdin.readline().rstrip()))
