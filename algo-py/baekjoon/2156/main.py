from typing import List, Any, Union

n = int(input())

l = [int(input()) for _ in range(n)]

dp: list[Union[int, Any]] = [l[0], l[1] + l[0], max(l[2] + l[1], l[2] + l[0])]
for i in range(3, n):
    dp.append(max(l[i] + dp[i - 2], l[i] + l[i - 1] + dp[i - 3]))

print(dp)
print(max(dp))
