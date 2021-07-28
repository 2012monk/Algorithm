def drink(n, arr):
    if n <= 2:
        return sum(arr)

    dp = [arr[0], arr[0] + arr[1]] + [0 for _ in range(n - 2)]
    dp[2] = max(max(arr[:2]) + arr[2], max(dp))

    for i in range(3, n):
        dp[i] = max(max(dp[i - 2], arr[i - 1] + dp[i - 3]) + arr[i], dp[i - 1])
    return dp[-1]


if __name__ == '__main__':
    t = int(input())
    print(drink(t, [int(input()) for _ in range(t)]))

# k = 6
# a = [6,
#      10,
#      13,
#      9,
#      8,
#      1]
# k = 2
# a = [1, 2]
#
# print(drink(k, a))
