n = int(input())

l = []
dp = []
for _ in range(n):
    l.append(list(map(int, input().split(" "))))


dp.append([l[0][0]])
dp.append(list(map(lambda x: x+dp[0][0], l[1])))

for i in range(2, n):
    t = [l[i][0] + dp[i - 1][0]]
    for j in range(1, len(l[i]) - 1):
        t.append(l[i][j] + max(dp[-1][j], dp[-1][j - 1]))
    t.append(l[i][-1] + dp[-1][-1])
    dp.append(t)

print(max(dp[-1]))




