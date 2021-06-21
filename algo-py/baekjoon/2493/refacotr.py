n = int(input())
l = list(map(int, input().split(" ")))
stack = []
res = []
peek = 0

for i in range(n):
    t = l[i]
    if not len(stack):
        res.append(0)
        stack.append((t, i))
        continue

    while len(stack) and stack[-1][0] < t:
        stack.pop()

    if not len(stack):
        res.append(0)
    elif stack[-1][0] >= t:
        res.append(stack[-1][1] + 1)

    stack.append((t, i))

print(*res)

