from sys import *

input = stdin.readline

def solution(n: int) -> int:
    dp = [0, 1, 1, 1, 2, 2] + [0] * n

    for i in range(5, n + 1):
        dp[i] = dp[i - 1] + dp[i - 5]

    return dp[n]


if __name__ == '__main__':
    for _ in range(int(input())):
        print(solution(int(input())))

