from bisect import bisect
import sys

input = sys.stdin.readline


def check(pre_sum, size, m):
    i = prev = 0
    for i in range(m):
        i = bisect(pre_sum, prev + size, lo=i)
        prev = pre_sum[i - 1]
    if i >= len(pre_sum):
        return True
    return False


def solution(A, m):
    pre_sum = [A[0]]
    for i in range(1, len(A)):
        pre_sum.append(pre_sum[i - 1] + A[i])

    lo, hi = max(max(A), pre_sum[-1] // m), pre_sum[-1]
    result = -1
    while lo <= hi:
        mid = (lo + hi) // 2
        if check(pre_sum, mid, m):
            result = mid
            hi = mid - 1
        else:
            lo = mid + 1

    return result


if __name__ == '__main__':
    n, k = map(int, input().split())
    c = list(map(int, input().split()))
    print(solution(c, k))