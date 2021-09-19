import sys


def solution():
    sys.setrecursionlimit(10 ** 6)
    input = sys.stdin.readline
    n, root, q = map(int, input().split())
    a = [[] for _ in range(n + 1)]
    size = [0] * (n + 1)
    for _ in range(n - 1):
        u, v = map(int, input().split())
        a[u].append(v)
        a[v].append(u)

    def dfs(root):
        size[root] = 1
        for node in a[root]:
            if size[node]:
                continue
            size[root] += dfs(node)
        return size[root]

    dfs(root)
    r = [str(size[int(input())]) for _ in range(q)]
    print('\n'.join(r))


solution()
