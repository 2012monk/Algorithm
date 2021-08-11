from collections import defaultdict


def track(i, s, arr, v):
    if i == len(arr):
        v[s] += 1
        return
    track(i + 1, s, arr, v)
    track(i + 1, s + arr[i], arr, v)


def solution(arr, t, n):
    a, b = defaultdict(int), defaultdict(int)
    l, r = arr[n // 2:], arr[:n // 2]
    track(0, 0, l, a)
    track(0, 0, r, b)
    a[0] -= 1
    b[0] -= 1
    res = a[t] + b[t]
    for s in a:
        if t - s in b:
            res += a[s] * b[t - s]
    return res


if __name__ == '__main__':
    n, t = map(int, input().split())
    arr = list(map(int, input().split()))
    print(solution(arr, t, n))
