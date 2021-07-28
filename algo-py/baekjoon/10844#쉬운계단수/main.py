def solution(n: int) -> int:
    m = 1000000000
    dp = [[0 for i in range(11)] for _ in range(n)]
    for i in range(10):
        dp[0][i] = 1

    for i in range(1, n):
        print(dp[i-1])
        dp[i][0] = dp[i - 1][1]
        dp[i][10] = 0
        for j in range(10):
            dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % m
        print(dp[i])
    return sum(dp[n - 1][1:10]) % m


if __name__ == '__main__':
    print(solution(int(input())))
