import sys

input = sys.stdin.readline
target = int(input())
k = input()
broken = list(map(int, input().split()))
ans = abs(target - 100)

if len(broken) == 10:
    print(ans)
    exit(0)
for i in range(1000001):
    number, f = str(i), 1
    for j in range(len(number)):
        if int(number[j]) in broken:
            f = 0
            break
    if f:
        ans = min(ans, abs(i - target) + len(number))
print(ans)
