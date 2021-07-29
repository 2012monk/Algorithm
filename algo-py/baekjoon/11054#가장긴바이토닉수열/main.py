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


if __name__ == '__main__':
    print(solution(int(input()), list(map(int, input().split()))))
# test code
# t = 10
# test = [1, 5, 2, 1, 4, 3, 4, 5, 2, 1]
#
# print(solution(10, test))
