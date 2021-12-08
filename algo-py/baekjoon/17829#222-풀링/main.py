def partion(x,y,grid):
    r = []
    for i in range(x, x + 2):
        for j in range(y, y + 2):
            r.append(grid[i][j])
    return sorted(r, reverse=True)[1]

def solution(n, grid):
    if n == 2:
        return partion(0,0,grid)
    tmp = [[0 for _ in range(n // 2)] for _ in range(n // 2)]
    for i in range(0, n - 1, 2):
        for j in range(0, n - 1, 2):
            tmp[i//2][j//2] = partion(i, j, grid)
    return solution(n//2, tmp)
    
if __name__ == '__main__':
    n = int(input())
    g = [list(map(int, input().split(' '))) for _ in range(n)]
    print(solution(n, g))
