import heapq
import sys
from collections import defaultdict


def solution(graph, start, t):
    q = [(0, start)]
    dist = defaultdict(lambda: float('inf'))

    while q:
        weight, node = heapq.heappop(q)
        if dist[node] < weight:
            continue
        dist[node] = weight
        for dv, dw in graph[node]:
            alt = dw + weight
            if dist[dv] > alt:
                dist[dv] = alt
                heapq.heappush(q, (alt, dv))

    return '\n'.join([str(dist[node]) if node in dist else 'INF' for node in range(1, t + 1)])


if __name__ == '__main__':
    input = sys.stdin.readline
    g = defaultdict(list)
    n, e = map(int, input().split())
    s = int(input())
    for _ in range(e):
        u, v, w = map(int, input().split())
        g[u].append((v, w))
    print(solution(g, s, n))
