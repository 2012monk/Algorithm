import sys

input = sys.stdin.readline


def count_h(grid, i, j):
    c = 1
    x = 1
    while j + x < n and grid[i][j] == grid[i][j + x]:
        c += 1
        x += 1
    x = 1
    while j - x >= 0 and grid[i][j] == grid[i][j - x]:
        c += 1
        x += 1
    return c


def count_v(grid, i, j):
    r, x = 1, 1
    while i + x < n and grid[i][j] == grid[i + x][j]:
        r += 1
        x += 1
    x = 1
    while i - x >= 0 and grid[i][j] == grid[i - x][j]:
        r += 1
        x += 1
    return r


def count(grid, i, j):
    return max(count_h(grid, i, j), count_v(grid, i, j))


def solution(grid):
    mx = 1
    for i in range(n):
        for j in range(n - 1):
            grid[i][j], grid[i][j + 1] = grid[i][j + 1], grid[i][j]
            mx = max(count(grid, i, j), mx)
            mx = max(count(grid, i, j + 1), mx)
            grid[i][j], grid[i][j + 1] = grid[i][j + 1], grid[i][j]

            grid[j][i], grid[j + 1][i] = grid[j + 1][i], grid[j][i]
            mx = max(count(grid, j, i), mx)
            mx = max(count(grid, j + 1, i), mx)
            grid[j][i], grid[j + 1][i] = grid[j + 1][i], grid[j][i]
            if mx == len(grid):
                return mx
    return mx


if __name__ == '__main__':
    n = int(input())
    grid = [list(input()) for _ in range(n)]
    print(solution(grid))
