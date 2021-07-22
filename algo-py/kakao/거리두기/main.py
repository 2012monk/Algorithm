from collections import deque


def search(line, n, m):
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    q = deque([[n, m]])

    ch = [[False for _ in range(5)] for _ in range(5)]
    ch[n][m] = True

    while len(q):
        c = q.popleft()

        for i in range(4):
            nx = c[0] + dx[i]
            ny = c[1] + dy[i]
            if 0 <= nx < 5 and 0 <= ny < 5 and abs(nx - n) + abs(ny - m) <= 2 and not ch[nx][ny]:
                if line[nx][ny] == 'P':
                    return True
                if line[nx][ny] == 'O':
                    q.append([nx, ny])
                    ch[nx][ny] = True
    return False

def check(line):
    for i in range(5):
        for j in range(5):
            if line[i][j] == 'P' and search(line, i, j):
                return 0
    return 1


def solution(places):
    a = []

    for i in range(5):
        a.append(check(places[i]))

    return a


test = [["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"],
        ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"],
        ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]

print(solution(test))
