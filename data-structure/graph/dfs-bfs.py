import sys
from collections import deque

graph = {
    1: [2, 3, 4],
    2: [5],
    3: [4],
    4: [5],
    5: [7, 6],
    6: [],
    7: [3, 5]
}


def dfs(n, visited=None):
    if visited is None:
        visited = []
    visited.append(n)

    for w in graph[n]:
        if w not in visited:
            visited = dfs(w, visited)
    return visited


print(dfs(1))


def bfs(start):
    visited = [start]
    q = deque([start])

    while q:
        n = q.popleft()
        for w in graph[n]:
            if w not in visited:
                visited.append(w)
                q.append(w)

    return visited


print(bfs(1))
