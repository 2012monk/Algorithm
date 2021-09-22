import sys


def solution(graph, n):
    res = []

    def dfs(node):
        if node in res:
            return
        while graph[node]:
            dfs(graph[node].pop())
        res.append(node)

    for i in range(1, n + 1):
        dfs(i)
    return res


if __name__ == '__main__':
    input = sys.stdin.readline
    n, m = map(int, input().split())
    g = [[] for _ in range(n + 1)]
    for _ in range(m):
        u, v = map(int, input().split())
        g[u].append(v)
    print(*solution(g, n))
