import sys
from collections import deque


def solution(graph, inDegree, n):
    q = deque([i for i in range(1, n + 1) if not inDegree[i]])

    r = []
    for i in range(1, n + 1):
        x = q.popleft()
        r.append(x)
        for node in graph[x]:
            inDegree[node] -= 1
            if inDegree[node] == 0:
                q.append(node)
    return r


if __name__ == '__main__':
    input = sys.stdin.readline
    n, m = map(int, input().split())
    g = [[] for _ in range(n + 1)]
    d = [0 for _ in range(n + 1)]
    for _ in range(m):
        u, v = map(int, input().split())
        g[u].append(v)
        d[v] += 1

    print(*solution(g, d, n))
