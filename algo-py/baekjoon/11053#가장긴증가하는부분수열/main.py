def solution(n, arr):
    dp = [0 for _ in range(1001)]

    for i in range(n):

        if dp[arr[i]] == 0:
            dp[arr[i]] = 1

        if arr[i] > 1 and dp[arr[i]] != 0:
            dp[arr[i]] = max(dp[:arr[i]])
            dp[arr[i]] += 1

    return max(dp)
if __name__ == '__main__':
    print(solution(int(input()), list(map(int, input().split()))))

t = 6
test = [10, 20, 10, 30, 20, 50]
# test = [1,2,1,3,2,5]

print(solution(6, test))
