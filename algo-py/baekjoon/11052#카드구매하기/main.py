
def solution(n, dp):

    for i in range(n + 1):
        # 조합에 따라 최댓값 탐색
        dp[i] = max([dp[i - k] + dp[k] for k in range(1+i//2)])
    return dp[n]


if __name__ == '__main__':
    print(solution(int(input()), [0] + list(map(int, input().split()))))



# test code


t = [4, 10, 10, 4, 4, 1]
test = [[1, 5, 6, 7],

        [1, 1, 2, 3, 5, 8, 13, 21, 34, 55],

        [5, 10, 11, 12, 13, 30, 35, 40, 45, 47],

        [5, 2, 8, 10],

        [3, 5, 15, 16],

        [1]]

result = [10, 55, 50, 20, 18, 1]

for k in range(len(t)):
    r = solution(t[k],[0] + test[k])
    print(r, r == result[k])

# print(solution(t, test))

