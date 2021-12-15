from collections import deque


def solution(rectangle, cx, cy, ix, iy):
    path = [[0 for _ in range(103)] for _ in range(103)]
    v = [[0 for _ in range(103)] for _ in range(103)]

    for sy, sx, dy, dx in rectangle:
        for i in range(sx * 2, dx * 2 + 1):
            for j in range(sy * 2, dy * 2 + 1):
                path[i][j] = 1
    for sy, sx, dy, dx in rectangle:
        for i in range(sx * 2 + 1, dx * 2):
            for j in range(sy * 2 + 1, dy * 2):
                path[i][j] = 0

    cx *= 2
    cy *= 2
    ix *= 2
    iy *= 2
    cx, cy = cy, cx
    ix, iy = iy, ix
    q = deque([(cx, cy, 0)])
    v[cx][cy] = 1

    while q:
        x, y, d = q.popleft()
        if x == ix and y == iy:
            return d // 2
        for nx, ny in zip([1, -1, 0, 0], [0, 0, 1, -1]):
            dx, dy = x + nx, y + ny
            if dx < 0 or dx >= 102 or dy < 0 or dy >= 102:
                continue
            if not path[dx][dy] or v[dx][dy]:
                continue
            v[dx][dy] = 1
            q.append((dx, dy, d + 1))
    return 0
