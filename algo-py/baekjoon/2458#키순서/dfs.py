import sys
sys.setrecursionlimit(int(1e10))

def dfs(g, n, v):
    v[n] = 1
    for u in g[n]:
        if not v[u]:
            dfs(g, u, v)


def solution(n, graph):
    v = [[0 for _ in range(n + 1)] for _ in range(n + 1)]
    for i in range(1, n + 1):
        dfs(graph, i, v[i])
    res = 0
    for i in range(1, n + 1):
        f = 1
        for j in range(1, n + 1):
            f &= v[i][j] | v[j][i]
        res += f
    return res


if __name__ == '__main__':
    input = sys.stdin.readline
    n, m = map(int, input().split())
    g = [[] for _ in range(n + 1)]
    for _ in range(m):
        u, v = map(int, input().split())
        g[u].append(v)
    print(solution(n, g))
