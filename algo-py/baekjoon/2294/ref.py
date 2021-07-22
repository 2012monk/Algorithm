n, k = map(int, input().split(" "))

l = [int(input()) for _ in range(n)]
dp = [0] + [10001 for _ in range(k + 1)]

# print(l)
for i in range(n):
    for j in range(l[i], k + 1):
        dp[j] = min(dp[j], dp[j - l[i]] + 1)


print(dp[k] if dp[k] != 10001 else -1)