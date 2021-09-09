import heapq
import sys
from collections import defaultdict

# 탐색을 줄이는 방법 참고 https://www.acmicpc.net/source/25449183

def solution(graph, n, v1, v2):
    #  V1 -> V2 == V2 -> V1 이 성립한다.
    # 그렇기 때문에 중복되는 문제는 빼고 탐색을 해도 답을 찾을수있다.
    # 1. 1 -> V1
    # 2. 1 -> V2
    # 3. V1 -> V2
    # 4. V1 -> N,
    # 5. V2 -> N
    # 결론적으로 기존의 6번의 탐색에서 2번으로 줄일수 있다.
    v1To1, v1Tov2, v1ToN = search(graph, n, v1, 1, v2, n)
    v2To1, v2ToN = search(graph,n,v2,1,n)
    r = min(v1To1+v2ToN, v2To1+v1ToN) + v1Tov2
    if r < 1e9:
        return r
    return -1


def search(graph, n, start, *end):
    dist = [1e9 for _ in range(n + 1)]
    q = [(0, start)]
    dist[0] = 0
    while q:
        weight, node = heapq.heappop(q)
        if dist[node] < weight:
            continue
        dist[node] = weight
        for v, w in graph[node]:
            dw = w + weight
            if dist[v] > dw:
                dist[v] = dw
                heapq.heappush(q, (dw, v))

    return (dist[i] for i in end)


if __name__ == '__main__':
    input = sys.stdin.readline
    V, E = map(int, input().split())
    g = defaultdict(list)
    for _ in range(E):
        u, v, w = map(int, input().split())
        g[v].append((u, w))
        g[u].append((v, w))
    v1, v2 = map(int, input().split())
    print(solution(g, V, v1, v2))
