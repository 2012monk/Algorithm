import math
from main import *

from util.counter import measure_time


def solution(n, r):
    dp = [1] + [0] * n

    for i in range(1, r + 1):
        for j in range(1, n + 1):
            dp[j] = dp[j - 1] + dp[j]

    return int(dp[n] % 1e9)


measure_time(solution, 200, 199)
measure_time(nHr, 200, 199)

# if __name__ == '__main__':
#     n, r = map(int, input().split())
#     print(solution(n, r))

# print(solution(20, 3))
