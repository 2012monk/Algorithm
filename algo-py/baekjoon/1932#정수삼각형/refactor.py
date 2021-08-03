import sys

input = sys.stdin.readline


def solution():
    n = int(input())
    dp = [0] * (n + 2)
    arr = list(map(int, input().split()))
    for i in range(1, n):
        dp[0] += arr[0]
        dp[i] += arr[i - 1]
        for j in range(1, i):
            dp[j] += max(arr[j], arr[j - 1])
        arr = list(map(int, input().split()))
        print(arr, dp)
    return max(dp)


print(solution())
