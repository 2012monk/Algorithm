def solution(n, arr):
    dp = [0] * (n + 1)

    for i, j in enumerate(arr):
        if i + j[0] < n:
            dp[i + j[0]] = dp[i] + j[1]
    return max(dp)


t = 7
tc = [(3, 10),
      (5, 20),
      (1, 10),
      (1, 20),
      (2, 15),
      (4, 40),
      (2, 200)]

solution(t, tc)
a = [0] * 20
for i, j in enumerate(tc):
    a[i + j[0]] = j[1]
print(a[:8])

import sys

input = sys.stdin.readline


def solution():
    n = int(input())
    dp = [0] * (n + 1)
    m = 0
    for i in range(n):
        j, v = map(int, input().split())
        m = max(dp[i], m)
        idx = i + j
        if idx <= n:
            dp[idx] = dp[idx] if dp[idx] > m + v else m + v

    print(max(dp))


if __name__ == '__main__':
    solution()
