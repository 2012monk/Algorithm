def solution(n, info):
    target = sum([10 - i for i in range(11) if info[i] > 0])
    res = []

    print(target)
    print(info)

    def solve(start, n, path, s1, s2):
        print(s1, s2, path)
        if start < 0:
            if s2 - s1 <= 0:
                return
            res.append((path, s2 - s1))
            if n > 0:
                res[-1][0][-1] = n
            return
        if n > info[start]:
            s = s1
            if info[start] > 0:
                s -= 10 - start
            solve(start - 1, n - info[start] - 1, [info[start] + 1] + path, s, s2 + 10 - start)
        solve(start - 1, n, [0] + path, s1, s2)

    solve(10, n, [], target, 0)

    res.sort(key=lambda x: [-x[1]] + [-x[0][10 - i] for i in range(11)])
    if res[0][1] < 0:
        return [-1]
    return res[0][0]

print(solution(10, [0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3]))
# print(solution(9, [0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1]))
# print(solution(1, [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]))
# print(solution(5, [2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0]))
# , [0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0]


# if start > 10:
#     r1 = 0
#     r2 = 0
#     print(path)
#     for i in range(11):
#         if path[i] == 0 and info[i] == 0:
#             continue
#         if path[i] > info[i]:
#             r1 += (10 - i)
#         else:
#             r2 += (10 - i)
#     print(r1, r2)
#     if r1 > r2:
#         res.append(path)
#     return
