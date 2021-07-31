def solution(n):
    dp = [1, 0, 3] + [0] * n

    for i in range(4, n + 1, 2):
        dp[i] += dp[i - 2] * 3
        for j in range(0, i - 3, 2):
            dp[i] += dp[j] * 2

    return dp[n]

if __name__ == '__main__':
    print(solution(int(input())))

print(solution(8))