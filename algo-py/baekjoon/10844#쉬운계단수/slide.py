def solution(n: int) -> int:
    m = 1000000000
    a = [0] + [1] * 9
    b = [0] * 10

    for _ in range(n - 1):
        b[0] = a[1]
        b[9] = a[8]
        for i in range(1, 9):
            b[i] = a[i - 1] + a[i + 1]
        a = b[:]
    print(a, b)
    return sum(a) % m


def slide(n: int) -> int:
    dp = [[0] * 12, [1 if 1 < i < 11 else 0 for i in range(12)]]

    for i in range(2, n + 1):
        for j in range(1, 11):
            dp[i % 2][j] = (dp[(i - 1) % 2][j - 1] + dp[(i - 1) % 2][j + 1]) % 1000000000

    return sum(dp[n % 2][1:]) % 1000000000


if __name__ == '__main__':
    # print(solution(int(input())))
    print(solution(3))
    print(slide(3))
