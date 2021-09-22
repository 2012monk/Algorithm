from collections import deque


def solution():
    n = int(input())
    graph = [[] for _ in range(n + 1)]
    cost = [0] * (n + 1)
    degree = [0] * (n + 1)
    for node in range(1, n + 1):
        i = list(map(int, input().split()))
        cost[node] = i[0]
        for nxt in i[1:-1]:
            graph[nxt].append(node)
            degree[node] += 1

    q = deque([i for i in range(1, n + 1) if not degree[i]])
    r = [0] * (n + 1)
    for _ in range(n):
        x = q.popleft()
        r[x] += cost[x]
        for child in graph[x]:
            degree[child] -= 1
            r[child] = max(r[child], r[x])
            if degree[child] == 0:
                q.append(child)

    print('\n'.join(map(str, r[1:])))


solution()
