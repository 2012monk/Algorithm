n, k = map(int, input().split())

l = set([])

for _ in range(n):
    i = int(input())
    if i <= k:
        l.add(i)

l = list(l)
l.sort()

dp = l.copy()

r = 0

print(r)

#
# while True:
#     # print(dp)
#     for i in range(len(dp)):
#         m = 0
#         for j in range(len(l) - 1, -1, -1):
#             if dp[i] == -1:
#                 break
#             if k - dp[i] - l[j] >= 0:
#                 m = l[j]
#                 break
#             elif i == k:
#                 break
#         if m == 0:
#             dp[i] = -1
#         else:
#             dp[i] += m
#
#     r += 1
#     if -1 in dp:
#         dp.remove(-1)
#     if k in dp:
#         # print(dp, "!23")
#         break
print(r)
