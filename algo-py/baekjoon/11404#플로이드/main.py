import sys
from collections import defaultdict

INF = 1e11


def solution(n, graph):
    dist = [[INF for _ in range(n + 1)] for _ in range(n + 1)]
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if i == j:
                dist[i][j] = 0
    for u in graph:
        for v,w in graph[u]:
            if dist[u][v] > w:
                dist[u][v] = w

    for k in range(1, n + 1):
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                if dist[i][j] > dist[i][k] + dist[k][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]

    res = []
    for i in range(1, n + 1):
        res.append(' '.join([str(dist[i][j]) if dist[i][j] != INF else '0' for j in range(1, n + 1)]))
    return '\n'.join(res)


if __name__ == '__main__':
    input = sys.stdin.readline
    n = int(input())

    g = defaultdict(list)
    for _ in range(int(input())):
        u, v, w = map(int, input().split())
        g[u].append((v,w))
    print(solution(n, g))
