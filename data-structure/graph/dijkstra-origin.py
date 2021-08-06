# input
# times = [[3, 1, 5], [3, 2, 2], [2, 1, 2], [3, 4, 1], [4, 5, 1], [5, 6, 1], [6, 7, 1], [7, 8, 1], [8, 1, 1]]
# 방향과 가중치를 가진 그래프
# priority queue 를 이용하지 않은 전체 탐색 O(|V|^2)
def dijkstra(times, n, start):
    graph = [[1e6 for _ in range(n + 1)] for _ in range(n + 1)]
    dist = [1e6 for _ in range(n + 1)]
    visited = set()
    q = [start]
    dist[start] = 0
    # adjacency matrix setup
    for u, v, w in times:
        # 간선의 가중치 업데이트
        graph[u][v] = w
    # BFS
    while q:
        v = q.pop(0)
        visited.add(v)
        # 모든 노드에 대해서 최솟값으로 업데이트
        for i in range(1, n + 1):
            a = dist[v] + graph[v][i]
            if a < dist[i]:
                dist[i] = a
            if i not in visited:
                q.append(i)

    return dist[1:]


tc = [[3, 1, 5], [3, 2, 2], [2, 1, 2], [3, 4, 1], [4, 5, 1], [5, 6, 1], [6, 7, 1], [7, 8, 1], [8, 1, 1]]
tc1 = [[2, 1, 1], [2, 3, 1], [3, 4, 1]]
# print(dijkstra(tc, 8, 3))
for e in enumerate(dijkstra(tc, 8, 3)):
    print(f'3 -> {e[0] + 1}, w= {e[1]}')
print()
for e in enumerate(dijkstra(tc1, 4, 2)):
    print(f'2 -> {e[0] + 1}, w= {e[1]}')
