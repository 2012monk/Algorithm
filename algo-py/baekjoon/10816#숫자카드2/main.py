import bisect as bs


def solution():
    _, a, _, m = input(), list(map(int, input().split())), input(), list(map(int, input().split()))
    a.sort()
    for k in m:
        print(bs.bisect_right(a, k) - bs.bisect_left(a, k), end=' ')


if __name__ == '__main__':
    solution()
