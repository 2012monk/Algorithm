def solution(n):
    dp = [0] * (n + 1)
    for i in range(2, n + 1):
        dp[i] = dp[i - 1] + 1
        if i % 2 == 0:
            dp[i] = min(dp[i], dp[i // 2] + 1)
        if i % 3 == 0:
            dp[i] = min(dp[i], dp[i // 3] + 1)

    return dp[n]
#
# for i in range(4, 20):
#     print(solution(i))

if __name__ == '__main__':
    print(solution(int(input())))
print(solution(5))
print(solution(7))

cache = {0: 0, 1: 1, 2: 1, 3: 1}


def solve(n):
    if n in cache:
        return cache[n]

    i = solve(n // 2) + (n % 2) + 1
    j = solve(n // 3) + (n % 3) + 1

    cache[n] = min(i, j)
    return cache[n]


if __name__ == '__main__':
    print(solve(int(input())))
