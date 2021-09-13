def solution(grid):
    n = len(grid)
    m = len(grid[0])

    g = [['0' for _ in range(m + 2)]] + [['0'] + list(g) + ['0'] for g in grid] + [['0' for _ in range(m + 2)]]
    v = [[[0, 0, 0, 0] for _ in range(m + 2)] for _ in range(n + 2)]
    direction = [(1, 0), (-1, 0), (0, 1), (0, -1)]

    def dfs(x, y, dist, d):
        # print(x, y, d)
        if v[x][y][d]:
            return dist
        v[x][y][d] = 1
        if g[x][y] in 'LRS':
            dist += 1
        nx, ny = direction[d]
        if g[x][y] == 'L':
            nx, ny = -direction[d][1], direction[d][0]
            d = direction.index((nx, ny))
        if g[x][y] == 'R':
            nx, ny = direction[d][1], -direction[d][0]
            d = direction.index((nx, ny))

        dx = (x + nx) % (n + 2)
        dy = (y + ny) % (m + 2)

        if dx < 0:
            dx = n + 1
        if dy < 0:
            dy = m + 1

        return dfs(dx, dy, dist, d)

    r = []

    for i in range(1, m + 1):
        if not v[0][i][0]:
            v[0][i][0] = 1
            r.append(dfs(1, i, 0, 0))
        if not v[n + 1][i][1]:
            v[n + 1][i][1] = 1
            r.append(dfs(n, i, 0, 1))

    for i in range(1, n + 1):
        if not v[i][0][2]:
            v[i][0][2] = 1
            r.append(dfs(i, 1, 0, 2))
        if not v[i][m + 1][3]:
            v[i][m + 1][3] = 1
            r.append(dfs(i, m, 0, 3))
    return sorted(r)


tc2 = ['R', 'R']
tc1 = ['L', 'R', 'L']
tc = ["SL", "LR"]
print(solution(tc1))
