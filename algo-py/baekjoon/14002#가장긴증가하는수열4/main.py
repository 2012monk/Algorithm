from bisect import bisect_left as bs


def solution(n, arr):
    lis = [arr[0]]
    trace = [0]

    for i in range(1, n):
        if lis[-1] < arr[i]:
            lis.append(arr[i])
            trace.append(len(lis) - 1)
        else:
            idx = bs(lis, arr[i])
            lis[idx] = arr[i]
            trace.append(idx)

    res = []
    p = len(lis) - 1
    for i, j in enumerate(reversed(trace)):
        if p < 0:
            break
        if j == p:
            res.append(arr[n - 1 - i])
            p -= 1

    return res[::-1]


if __name__ == '__main__':
    r = solution(int(input()), list(map(int, input().split())))
    print(len(r))
    print(*r)

'''
t = 6
test = [1, 5, 6, 2, 3, 4]

t = 5
test = [2, 3, 2, 4, 1]

t = 4
test = [-1, 3, -2, 2]

print(*solution(t, test))

'''
