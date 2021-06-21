tmp = []
stack = []
res = []


def co(t):
    if not len(stack):
        res.append(0)
        stack.append(t)
    elif stack[-1] >= t:
        res.append(len(stack))
        stack.append(t)
    else:
        while True:
            tmp.append(stack.pop())
            if len(stack) == 0 or stack[-1] >= t:
                res.append(len(stack))
                for i in tmp[::-1]:
                    stack.append(i)
                stack.append(t)
                tmp.clear()
                break


n = int(input())

towers = list(map(int, input().split(" ")))
for to in towers:
    co(to)

print(str.join(" ", list(map(str, res))))
