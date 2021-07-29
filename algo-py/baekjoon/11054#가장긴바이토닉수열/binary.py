def search(arr, t):
    l = 0
    r = len(arr)
    while l <= r:
        m = (l + r) // 2
        if arr[m] >= t:
            r = m - 1
        else:
            l = m + 1

    return l


def calc(arr, seq, dp, i):
    if seq[-1] < arr[i]:
        seq.append(arr[i])
        dp[i] = len(seq)
    else:
        idx = search(seq, arr[i])
        seq[idx] = arr[i]
        dp[i] = idx + 1


def solution(n, arr):
    rev = arr[::-1]
    inc = [arr[0]]
    dec = [rev[0]]

    dp_inc = [1] * n
    dp_dec = [1] * n

    for i in range(1, n):
        calc(arr, inc, dp_inc, i)
        calc(rev, dec, dp_dec, i)

    return max(map(lambda x: x[0] + x[1] - 1, zip(dp_inc, dp_dec[::-1])))


# if __name__ == '__main__':
#     print(solution(int(input()), list(map(int, input().split()))))
# test code
t = 10
test = [1, 5, 2, 1, 4, 3, 4, 5, 2, 1]

print(solution(10, test))
