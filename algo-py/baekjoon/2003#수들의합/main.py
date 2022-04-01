import sys

input = sys.stdin.readline
if __name__ == '__main__':
    n, m = map(int, input().split())
    arr = list(map(int, input().split()))
    lo, hi = 0, 0
    r = 0
    cur = 0
    while 1:
        if cur >= m:
            cur -= arr[lo]
            lo += 1
        elif hi == n:
            break
        else:
            cur += arr[hi]
            hi += 1
        if cur == m:
            r += 1

    print(r)
