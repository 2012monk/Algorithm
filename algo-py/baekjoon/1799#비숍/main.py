def dfs(x, y, d, f):
    if y >= n:
        x += 1
        if y % 2 == 0:
            y = 1
        else:
            y = 0
    if x >= n:
        return d
    ret = 0
    if grid[x][y] and not check_l[x + y] and not check_r[x - y + n]:
        check_l[x + y] = True
        check_r[x - y + n] = True
        ret = max(ret, dfs(x, y + 2, d + 1, f))
        check_l[x + y] = False
        check_r[x - y + n] = False
    ret = max(ret, dfs(x, y + 2, d, f))
    return ret


n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]
ans = 0
check_l = [0 for _ in range(50)]
check_r = [0 for _ in range(50)]
ans += dfs(0, 0, 0, 1)
ans += dfs(0, 1, 0, 0)
print(ans)
