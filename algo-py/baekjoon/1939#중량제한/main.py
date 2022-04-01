import sys


def find(x):
    if factories[x] != x:
        factories[x] = find(factories[x])
    return factories[x]


def union(x, y):
    a, b = map(find, (x, y))
    if a == b:
        return
    factories[a] = b


def isUnion(x, y):
    return find(x) == find(y)


input = sys.stdin.readline
if __name__ == '__main__':
    n, m = map(int, input().split())
    factories = [i for i in range(n + 1)]
    l = [list(map(int, input().split())) for _ in range(m)]
    x, y = map(int, input().split())
    l.sort(key=lambda data: -data[2])
    for i, j, c in l:
        union(i, j)
        if isUnion(x, y):
            print(c)
            break
