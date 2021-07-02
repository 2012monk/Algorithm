cases = [[6, 10, 2], [3, 30, 34, 5, 9], [2400, 21, 2900, 22, 2002, 3, 20]]

#
# def quick(l, st, end):
#     if st >= end:
#         return
#     i, j = st + 1, end
#
#     p = st
#     while i <= j:
#         while i <= end and l[i][0] < l[p][0]:
#             i += 1
#         while j >= 0 and l[j][0] > l[p][0]:
#             j -= 1
#
#     if i > j:
#         l[p], l[j] = l[j], l[p]
#     else:
#         l[i], l[j] = l[j], l[i]
#
#     quick(l, st, j - 1)
#     quick(l, j + 1, end)
#
#
# li = list(map(str, cases[2]))
# print(quick(li, 0, len(cases[2]) - 1))


def solution(n):
    arr = list(map(str, n))
    res = [arr[0]]
    buf = []

    for s in arr[1:]:
        while res and int(res[-1] + s) < int(s + res[-1]):
            buf.append(res.pop())

        res.append(s)
        res += buf[::-1]
        buf = []

    return "".join(res)


def sol(n):
    arr = list(map(str, n))

    for i in range(len(arr)):
        for j in range(i, len(arr)):
            if arr[i][0] < arr[j][0]:
                arr[i], arr[j] = arr[j], arr[i]
            elif arr[i][0] == arr[j][0]:
                if arr[i] + arr[j] < arr[j] + arr[i]:
                    # print(arr)
                    arr[i], arr[j] = arr[j], arr[i]

    return "".join(arr)


# for c in cases:
#     print(sol(c))
#
# print(sol([10, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]))
# print(sol([412, 41]))
# print(sol([303, 30]))


def sol2(n):
    arr = list(map(lambda x: (str(x) + "".zfill(4 - len(str(x))), len(str(x))), n))
    res = [arr[0]]
    buf = []

    for s in arr[1:]:
        while res and int(res[-1][0] + s[0]) < int(s[0] + res[-1][0]):
            buf.append(res.pop())

        res.append(s)
        res += buf[::-1]
        buf = []

    r = "".join(map(lambda x: x[0][:x[1]], res))
    return r


for c in cases:
    # print(sol2(c))
    # c.sort(key=lambda x: x*3, reverse=True)
    a = list(map(str, c))
    a.sort(key=lambda x: x*3)
    print(*a)
