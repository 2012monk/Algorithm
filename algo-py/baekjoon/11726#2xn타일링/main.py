def solution(n: int) -> int:
    dp = [1, 2, 3] + [0 for _ in range(n - 1)]

    for i in range(3, n):
        dp[i] = dp[i - 1] + dp[i - 2]

    return dp[n - 1] % 10007

if __name__ == '__main__':
    print(solution(int(input())))
