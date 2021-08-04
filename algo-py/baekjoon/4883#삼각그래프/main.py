import sys

# 일반 input 쓰면 시간초과
input = sys.stdin.readline


def solution(n, dp):
    dp[0][0] = sys.maxsize
    dp[0][2] += dp[0][1]

    for i in range(1, n):
        dp[i][0] += min(dp[i - 1][:2])
        dp[i][1] += min(dp[i - 1] + [dp[i][0]])
        dp[i][2] += min(dp[i - 1][1:] + [dp[i][1]])

    return dp[n - 1][1]


if __name__ == '__main__':
    t = 1
    while 1:
        n = int(input())
        if n == 0:
            break
        a = [list(map(int, input().split())) for _ in range(n)]
        print('{0}. {1}'.format(t, solution(n, a)))
        t += 1

'''
test case

3
0 0 0
-1 0 0
-1 0 -1
2
-20 0 -1
0 -2 0
2
13 7 5
15 6 16
4
13 7 -900
7 13 6
14 3 12
15 6 16
4
13 7 5
7 13 6
14 3 12
15 6 16
0
'''
