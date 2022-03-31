import sys

sys.setrecursionlimit(10 ** 7)
drawers = [-1] * 300001


def find(x):
    if drawers[x] <= 0:
        return x
    drawers[x] = find(drawers[x])
    return drawers[x]


def union(x, y):
    a = find(x)
    b = find(y)
    if a == b:
        return
    drawers[a] += drawers[b]
    drawers[b] = a


input = sys.stdin.readline
if __name__ == '__main__':
    n, m = map(int, input().split())
    ans = []
    for i in range(1, n + 1):
        a, b = map(int, input().split())
        if drawers[find(a)] + drawers[find(b)] < 0:
            print('LADICA')
            union(a, b)
            drawers[find(a)] += 1
        else:
            print('SMECE')
