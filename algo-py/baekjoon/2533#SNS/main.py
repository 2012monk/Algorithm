import sys


def solution(tree: list[list[int]], n):
    cache = [[-1 for _ in range(n + 1)] for _ in range(n + 1)]

    def dfs(node, skipped):
        if not tree[node]:
            return skipped
        if cache[node][skipped] != -1:
            return cache[node][skipped]

        if skipped:
            res = sum([min(dfs(child, 0), dfs(child, 1)) for child in tree[node]]) + 1
        else:
            res = sum([dfs(child, 1) for child in tree[node]])

        cache[node][skipped] = res
        return res

    return min(dfs(1, 0), dfs(1, 1))


if __name__ == '__main__':
    input = sys.stdin.readline
    sys.setrecursionlimit(int(1e8))
    n = int(input())
    a = [[] for _ in range(n + 1)]
    for _ in range(n - 1):
        u, v = map(int, input().split())
        a[u].append(v)
        a[v].append(u)
    tree = [[] for _ in range(n + 1)]


    def build(root, parent):
        if parent != 0:
            tree[parent].append(root)
        for node in a[root]:
            if node != parent:
                build(node, root)


    build(1, 0)
    print(solution(a, n))
