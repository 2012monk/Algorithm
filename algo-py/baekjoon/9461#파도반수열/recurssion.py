from sys import *

input = stdin.readline


def solution(n: int) -> int:
    dp = [0, 1, 1, 1, 2, 2] + [0] * n
    return rec(n, dp)


def rec(n: int, dp: list[int]) -> int:
    if not dp[n]:
        dp[n] = rec(n - 2, dp) + rec(n - 3, dp)
    return dp[n]


if __name__ == '__main__':
    for _ in range(int(input())):
        print(solution(int(input())))
