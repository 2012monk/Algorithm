import sys

input = sys.stdin.readline
sys.setrecursionlimit(10**7)


def dfs(i, j):
    dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]
    if i == m - 1 and j == n - 1:
        return 1

    if dp[i][j] == - 1:
        dp[i][j] = 0
        for nx, ny in zip(dx, dy):
            x, y = i + nx, j + ny
            if 0 <= x < m and 0 <= y < n and arr[i][j] > arr[x][y]:
                dp[i][j] += dfs(x, y)

    return dp[i][j]


if __name__ == '__main__':
    m, n = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(m)]
    dp = [[-1 for _ in range(n)] for _ in range(m)]
    print(dfs(0, 0))

m, n = 4, 5
arr = tc = [[50, 45, 37, 32, 30],
      [35, 50, 40, 20, 25],
      [30, 30, 25, 17, 28],
      [27, 24, 22, 15, 10]
      ]
dp = [[-1 for _ in range(n)] for _ in range(m)]
print(dfs(0, 0))

# print(solution(m, n, tc))
# for j in solution(m, n, tc):
#     print(*j)
