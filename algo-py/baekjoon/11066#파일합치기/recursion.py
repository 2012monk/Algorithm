def solution(n, cost):
    dp = [[-1 for _ in range(n + 1)] for _ in range(n + 1)]
    s = [0 for _ in range(n + 1)]
    for i in range(1, n + 1):
        s[i] = cost[i - 1] + s[i - 1]

    def find(x, y):
        if x == y:
            return 0
        if x + 1 == y:
            dp[x][y] = s[y + 1] - s[x]
        if dp[x][y] == -1:
            dp[x][y] = min([find(x, k) + find(k + 1, y) for k in range(x, y)], default=0) + s[y + 1] - s[x]
        return dp[x][y]

    res = [find(0, i) + find(i + 1, n - 1) for i in range(n)]
    return res[-1]


if __name__ == '__main__':
    for _ in range(int(input())):
        print(solution(int(input()), list(map(int, input().split()))))
# t = 4
# tc = [40, 30, 30, 50]

t = 15
tc = [1, 3, 3, 4, 4, 5, 5, 14, 17, 21, 21, 21, 32, 35, 98]
print(solution(t, tc))
