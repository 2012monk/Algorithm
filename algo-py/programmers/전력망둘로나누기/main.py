def solution(n, wires):
    g = [[0] * n for _ in range(n)]
    for u, v in wires:
        g[u - 1][v - 1] = 1
        g[v - 1][u - 1] = 1

    visited = [0] * n
    result = 10 ** 5

    def dfs(x):
        if visited[x]:
            return 0
        visited[x] = 1
        count = 0
        for i in range(n):
            if not g[x][i]:
                continue
            count += dfs(i)
        return count + 1

    for u, v in wires:
        g[u - 1][v - 1] = 0
        g[v - 1][u - 1] = 0
        visited = [0] * n
        r = abs(n - dfs(u) * 2)
        result = min(result, r)
        g[u - 1][v - 1] = 1
        g[v - 1][u - 1] = 1

    return result


print(solution(9, [[1, 3], [2, 3], [3, 4], [4, 5], [4, 6], [4, 7], [7, 8], [7, 9]]))

print(solution(4, [[1, 2], [2, 3], [3, 4]]))
