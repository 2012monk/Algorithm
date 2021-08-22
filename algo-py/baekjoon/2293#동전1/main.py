from sys import stdin


def solution(arr: list[int], total: int) -> int:
    dp = [1] + [0] * total

    for coin in arr:
        for current_value in range(coin, total + 1):
            dp[current_value] += dp[current_value - coin]
    return dp[total]


if __name__ == '__main__':
    n, k = map(int, stdin.readline().split())
    print(solution(list(map(int, stdin.read().split())), k))

tc = [1, 2, 5]
k = 10

print(solution(tc, k))
