n = int(input())
p = []
for i in range(n):
    p.append(list(map(int, input().split())))
for i in range(1, len(p)):
    # 각 node를 골랐을때 연속되지 않은 인덱스의 최솟값을 더해나간다
    p[i][0] = min(p[i - 1][1], p[i - 1][2]) + p[i][0]
    p[i][1] = min(p[i - 1][0], p[i - 1][2]) + p[i][1]
    p[i][2] = min(p[i - 1][0], p[i - 1][1]) + p[i][2]
print(min(p[n - 1][0], p[n - 1][1], p[n - 1][2]))