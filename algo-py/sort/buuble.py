import random
n = 2 ** 12
t = [random.randint(1, n) for _ in range(n)]
# t = [3,5,8,10,11,15,17,567,6,2]
l = t.copy()
n = len(t)
cnt = 0
for i in range(n):
    for j in range(n - i - 1):
        if t[j] > t[j + 1]:
            # t[i], t[j] = t[j], t[i]
            t[j], t[j + 1] = t[j + 1], t[j]

        cnt += 1

print(t)
print(cnt)

cnt = 0

for i in range(n):
    for j in range(i, n):
        if l[i] > l[j]:
            l[i], l[j] = l[j], l[i]
        cnt += 1

print(l)
print(cnt)

for i, j in zip(l, t):
    if i != j:
        print('no')
        exit(0)
print('yes')