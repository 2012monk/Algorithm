import sys
from collections import Counter

input = sys.stdin.readline


def solve(arr):
    n = len(arr)
    arr.sort()
    c = Counter(arr)
    w = []
    for i in range(1, n + 1):
        w.append(arr[n - i] * i)
    return max(w)


if __name__ == '__main__':
    print(solve([int(input()) for _ in range(int(input()))]))
