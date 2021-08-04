import sys

M = sys.maxsize
input = sys.stdin.readline

# knuth 최적화 적용 O(n^2)
def solution(n, cost):
    s = [0] + cost
    dp = [[M for _ in range(n)] for _ in range(n)]
    v = [[0 for _ in range(n)] for _ in range(n)]

    for t in range(n):
        dp[t][t] = 0
        v[t][t] = t
        s[t + 1] += s[t]

    for k in range(1, n):
        for j in range(k, n):
            i = j - k
            for l in range(v[i][j - 1], min(v[i + 1][j] + 1, j)):
                mn = dp[i][l] + dp[l + 1][j]
                if mn < dp[i][j]:
                    dp[i][j] = mn
                    v[i][j] = l
            dp[i][j] += s[j + 1] - s[i]
    return dp[0][n - 1]


if __name__ == '__main__':
    for _ in range(int(input())):
        print(solution(int(input()), list(map(int, input().split()))))

t = 4
tc = [40, 30, 30, 50]

print(solution(t, tc))
