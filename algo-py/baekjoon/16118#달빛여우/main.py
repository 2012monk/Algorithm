import heapq
import sys

INF = 2000000000


def wolf(graph, n):
    d = [[INF] * (n + 1) for _ in range(2)]
    q = [(0, 1, 0)]
    d[1][1] = 0
    while q:
        weight, node, step = heapq.heappop(q)
        st = step ^ 1
        if d[st][node] < weight:
            continue

        for nv, nw in graph[node]:
            cost = weight
            if step:
                cost += (nw * 2)
            else:
                cost += (nw // 2)
            if d[step][nv] > cost:
                d[step][nv] = cost
                heapq.heappush(q, (cost, nv, st))

    return d


def fox(graph, n):
    d = [INF] * (n + 1)
    q = [(0, 1)]
    d[1] = 0
    while q:
        weight, node = heapq.heappop(q)
        if d[node] < weight:
            continue

        for v, w in graph[node]:
            cost = weight + w
            if d[v] > cost:
                d[v] = cost
                heapq.heappush(q, (cost, v))
    return d


input = sys.stdin.readline
V, E = map(int, input().split())
g = [[] for i in range(V+1)]

for _ in range(E):
    u, v, w = map(int, input().split())
    g[u].append((v, w * 2))
    g[v].append((u, w * 2))

w = wolf(g, V)
f = fox(g, V)
r = 0
for i in range(1, V + 1):
    if f[i] < min(w[0][i], w[1][i]):
        r+=1
print(r)
