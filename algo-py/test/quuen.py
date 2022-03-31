from collections import deque


def solution(rectangle, cx, cy, ix, iy):
    path = [[0 for _ in range(103)] for _ in range(103)]
    v = [[0 for _ in range(103)] for _ in range(103)]

    for sx, sy, dx, dy in rectangle:
        for i in range(sx * 2, dx * 2 + 1):
            for j in range(sy * 2, dy * 2 + 1):
                path[i][j] = 1
    for sx, sy, dx, dy in rectangle:
        for i in range(sx * 2, dx * 2 + 1):
            for j in range(sy * 2, dy * 2 + 1):
                path[i][j] = 0

    cx *= 2
    cy *= 2
    ix *= 2
    iy *= 2
    q = deque([(cx, cy, 0)])

    while q:
        x, y, d = q.popleft()
        v[x][y] = 1
        if x == ix and y == iy:
            return d // 2
        for dx, dy in map(lambda dt: (x + dt[0], y + dt[1]), zip([1, -1, 0, 0], [0, 0, 1, -1])):
            if dx < 0 or dx >= 102 or dy < 0 or dy >= 102:
                continue
            if not path[dx][dy] or v[dx][dy]:
                continue
            q.append((dx, dy, d + 1))
    return 0
