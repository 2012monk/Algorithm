arr = [1, 5, 2, 6, 3, 7, 4]

command = [[2, 5, 3], [4, 4, 1], [1, 7, 3]]


def sort(l):
    res = [l[0]]
    buf = []

    for i in l[1:]:
        while res and res[-1] > i:
            # print(*res)
            buf.append(res.pop())

        res.append(i)
        res = res + buf[::-1]
        buf = []
    return res


print(*sort(arr))
result = []
for i in command:
    result.append(sort(arr[i[0] -1:i[1]])[i[2]-1])

print(result)

