import sys

input = sys.stdin.readline
if __name__ == '__main__':
    n = int(input())

    hi, lo = 0, 0
    min_grid = list(map(int, input().split()))
    max_grid = min_grid.copy()
    for _ in range(n - 1):
        cur = list(map(int, input().split()))
        tmp = [0, 0, 0]
        tmp[0] = cur[0] + max(max_grid[0], max_grid[1])
        tmp[1] = cur[1] + max(max_grid)
        tmp[2] = cur[2] + max(max_grid[1], max_grid[2])
        max_grid = tmp
        tmp = [0, 0, 0]
        tmp[0] = cur[0] + min(min_grid[0], min_grid[1])
        tmp[1] = cur[1] + min(min_grid)
        tmp[2] = cur[2] + min(min_grid[1], min_grid[2])
        min_grid = tmp
    print(max(max_grid), end=' ')
    print(min(sys.maxsize, min(min_grid)))
