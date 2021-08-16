from sys import stdin

input = stdin.readline


def cut(arr, n):
    arr.sort()
    lo, hi = 1, arr[-1]

    while lo < hi:
        mid = (lo + hi + 1) // 2
        t = sum([x // mid for x in arr])
        if t >= n:
            lo = mid
        else:
            hi = mid - 1

    return lo


if __name__ == '__main__':
    k, n = map(int, input().split())
    a = list(map(int, stdin.readlines()))
    print(cut(a, n))
