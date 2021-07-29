def solution(n, arr):
    dp = [arr[0]] + [0] * (n - 1)

    for i in range(1, n):
        dp[i] = max(arr[i], dp[i - 1] + arr[i])

    return max(dp)


if __name__ == '__main__':
    print(solution(int(input()), list(map(int, input().split()))))
t = 10
test = [10, -4, 3, 1, 5, 6, -35, 12, 21, -1]
print(solution(t, test))
