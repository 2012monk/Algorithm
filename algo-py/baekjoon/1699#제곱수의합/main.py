from math import *
import sys
sys.setrecursionlimit(10**6)


def find(dp, n):
    s = sqrt(n)
    if s == int(s):
        return 1
    if n <= 3:
        return n
    if not dp[n]:
        cache = []
        for k in range(int(sqrt(n // 2)), int(s) + 1):
            cache.append(find(dp, n - k * k))
        dp[n] = min(cache) + 1

    return dp[n]


def solution(n):
    dp = [0 for _ in range(n + 1)]
    return find(dp, n)


if __name__ == '__main__':
    for i in range(1, 20):
        print(i, solution(i))

    print(solution(int(input())))
    # print(solution(10000))
    # print(solution(111))
