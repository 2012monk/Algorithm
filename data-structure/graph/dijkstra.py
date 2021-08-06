from collections import defaultdict
import heapq
from typing import List


# leetcode 문제
# https://leetcode.com/problems/network-delay-time/

def solution(times: List[List[int]], n: int, start: int) -> int:
    graph = defaultdict(list)
    for u, v, w in times:
        graph[u] += (v, w)

    return dijkstra(graph, start, total=n)


def dijkstra(graph, source, total):
    # 최소 비용을 저장
    dist = defaultdict(int)
    # 시작노드만 q 에 넣고 시작
    q = [(0, source)]

    while q:
        weight, node = heapq.heappop(q)
        # 최솟값만 업데이트
        if node not in dist:
            dist[node] = weight
            for v, w in graph[node]:
                alt = dist[node] + w
                heapq.heappush(q, (alt, v))

    if len(dist) == total:
        return max(dist.values())
    return -1


''' wiki pseudo code
function Dijkstra(Graph, source):
      dist[source] ← 0                                    // 초기화

      create vertex set Q

      for each vertex v in Graph:
              if v ≠ source
              dist[v] ← INFINITY                          // 소스에서 v까지의 아직 모르는 길이
          prev[v] ← UNDEFINED                             // v의 이전 노드

         Q.add_with_priority(v, dist[v])


     while Q is not empty:                          // 메인 루프
         u ← Q.extract_min()                         // 최고의 꼭짓점을 제거하고 반환한다
         for each neighbor v of u:              // Q에 여전히 남아 있는 v에 대해서만
             alt ← dist[u] + length(u, v)
             if alt < dist[v]
                 dist[v] ← alt
                 prev[v] ← u
                 Q.decrease_priority(v, alt)

     return dist, prev
'''
