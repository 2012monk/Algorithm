import sys

sys.setrecursionlimit(10 ** 5)

uf = {}


def find(x):
    if x != uf[x]:
        uf[x] = find(uf[x])
    return uf[x]


def union(x, y):
    _x = find(x)
    _y = find(y)
    if _x == _y:
        return
    uf[_x] = uf[_y]


def result(x, y):
    if find(x) == find(y):
        return 'YES'
    return 'NO'


Input = lambda: sys.stdin.readline()

if __name__ == '__main__':
    n, m = map(int, Input().split())
    for i in range(n + 1):
        uf[i] = i
    for _ in range(m):
        op, x, y = map(int, Input().split())
        if op == 0:
            union(x, y)
        if op == 1:
            print(result(x, y))
