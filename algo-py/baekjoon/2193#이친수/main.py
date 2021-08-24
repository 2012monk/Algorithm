def solution(n):
    dp = [0, 1, 1, 2] + [0] * n
    for i in range(4, n + 1):
        dp[i] = dp[i - 2] + dp[i - 1]
    return dp[n]


# if __name__ == '__main__':
#     print(solution(int(input())))

f = open("./answer.txt", mode='w')

ans = [str(solution(i)) for i in range(1, 51)]
f.write(','.join(ans))
