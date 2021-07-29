import sys

input = sys.stdin.readline


def solution(n, arr):
    if n <= 2:
        return sum(arr)
    dp = [0] * n
    dp[0] = arr[0]
    dp[1] = arr[0] + arr[1]
    dp[2] = max(arr[:2]) + arr[2]
    for i in range(3, n):
        dp[i] = max(dp[i - 2], arr[i - 1] + dp[i - 3]) + arr[i]

    return dp[-1]


if __name__ == '__main__':
    n = int(input())
    case = [int(input()) for _ in range(n)]
    print(solution(n, case))
