n = int(input())

l = [int(input()) for _ in range(n)]


def s(l):
    if len(l) == 1:
        return l[0]

    if len(l) == 2:
        return max(l[0], l[0] + l[1])

    dp = [l[0], max(l[0] + l[1], l[0]), max(l[1] + l[2], l[2] + l[0])]
    dp[2] = max(dp)

    for i in range(3, n):
        dp.append(max(dp[i - 2], l[i - 1] + dp[i - 3]) + l[i])
        dp[i] = max(dp[i], dp[i - 1])

    return max(dp)


print(s(l))
