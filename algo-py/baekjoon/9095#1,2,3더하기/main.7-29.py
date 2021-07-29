import sys

input = sys.stdin.readline


def solution(n: int) -> int:

    dp = [1, 2, 4] + [0] * n
    for i in range(3, n):
        dp[i] = sum(dp[i - 3:i])
    return dp[n - 1]


if __name__ == '__main__':
    for _ in range(int(input())):
        print(solution(int(input())))
# print(solution(4))
# print(solution(7))
# print(solution(10))

