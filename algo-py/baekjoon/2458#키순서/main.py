import sys

# pypy 1103ms python TLE

def solution(n, m):
    dist = [[0 for _ in range(n + 1)] for _ in range(n + 1)]
    for _ in range(m):
        u, v = map(int, input().split())
        dist[u][v] = 1

    for k in range(1, n + 1):
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                if dist[i][k] and dist[k][j]:
                    dist[i][j] = 1

    res = 0
    for i in range(1, n + 1):
        f = 1
        for j in range(1, n + 1):
            if i == j:
                continue
            f &= dist[i][j] | dist[j][i]
        res += f
    return res


input = sys.stdin.readline
print(solution(*map(int, input().split())))
