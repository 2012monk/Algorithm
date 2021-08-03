def solution(n, arr):
    rev = arr[::-1]
    inc = [1 for _ in range(n)]
    dec = [1 for _ in range(n)]

    for i in range(n):
        for j in range(i):
            if arr[i] > arr[j]:
                inc[i] = max(inc[i], inc[j] + 1)
            if rev[i] > rev[j]:
                dec[i] = max(dec[i], dec[j] + 1)

    res = list(map(lambda x: x[0] + x[1] - 1, zip(inc, dec[::-1])))
    return max(res)


#
# if __name__ == '__main__':
#     print(solution(int(input()), list(map(int, input().split()))))
#

# test code
# t = 10
# test = [1, 5, 2, 1, 4, 3, 4, 5, 2, 1]
#
# print(solution(10, test))


def search(t, arr):
    l = 0
    r = len(arr) - 1
    while l <= r:
        m = (l + r) // 2
        if arr[m] >= t:
            r = m - 1
        else:
            l = m + 1
    return l


def len_lis(n, arr):
    lis = []
    dp = [1] * n

    for i in range(n):
        if not lis or lis[-1] < arr[i]:
            lis.append(arr[i])
            dp[i] = len(lis)
        else:
            x = search(arr[i], lis)
            lis[x] = arr[i]
            dp[i] = x + 1

    return dp


def solution_2(n, arr):
    inc = len_lis(n, arr)
    dec = len_lis(n, arr[::-1])

    return max(list(map(lambda x: x[0] + x[1] - 1, zip(inc, dec[::-1]))))


if __name__ == '__main__':
    print(solution_2(int(input()), list(map(int, input().split()))))
# test code
t = 10
test = [1, 5, 2, 1, 4, 3, 4, 5, 2, 1]

print(solution_2(t, test))
