# python3 시간초과
import sys
input = sys.stdin.readline


def solution(n, cost):
    dp = [[0 for _ in range(n + 1)] for _ in range(n + 1)]
    s = [0] * (n + 1)

    for i in range(1, n + 1):
        s[i] = s[i - 1] + cost[i - 1]

    # 구간의 길이 2 ~ n
    for i in range(2, n + 1):

        # 시작위치 1 ~ n - 구해야하는 길이
        for j in range(1, n - i + 2):
            #   두 구간으로 나누었을때 각 조합의 합 중 최솟값
            tmp = min([dp[j][j + k] + dp[j + k + 1][j + i - 1] for k in range(i - 1)])
            # 시작위치 ~ 구간의 최솟값
            dp[j][j + i - 1] = tmp + s[j + i - 1] - s[j - 1]  # + 시작위치~길이 만큼의 누적 합

    return dp[1][n]  # 처음 부터 n 길이 만큼의 최소


if __name__ == '__main__':
    for _ in range(int(input())):
        print(solution(int(input()), list(map(int, input().split()))))

# test code

t = 4
tc = [40, 30, 30, 50]

"""dp 배열
각 길이
2   0   1   2   3   4  
------------------------
0   0   0   0   0   0  
1   0   0   70  0   0  
2   0   0   0   60  0  
3   0   0   0   0   80 
4   0   0   0   0   0  

3   0   1   2   3   4  
------------------------
0   0   0   0   0   0  
1   0   0   70  160 0  
2   0   0   0   60  170
3   0   0   0   0   80 
4   0   0   0   0   0  

4   0   1   2   3   4  
------------------------
0   0   0   0   0   0  
1   0   0   70  160 300
2   0   0   0   60  170
3   0   0   0   0   80 
4   0   0   0   0   0  
300
"""
# t = 15
# tc = [1, 3, 3, 4, 4, 5, 5, 14, 17, 21, 21, 21, 32, 35, 98]

r = 0
dp = [0] * t

# print(tc[-1])
print(solution(t, tc))

# print(i, ' ', *['{0:<3}'.format(i) for i in range(5)])
# print('-' * 24)
# for idx, a in enumerate(dp):
#     print('{0:<3}'.format(idx), *list(map(lambda x: '{0:<3}'.format(x), a)))
# print()
