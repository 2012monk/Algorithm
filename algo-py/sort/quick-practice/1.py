import numpy as np
import random


def pr():
    n = 2 * 3

    test = [random.randint(1, n) for _ in range(n)]
    comp = test.copy()
    sort(test, 0, n - 1)
    comp.sort()
    t = np.array_equal(test, comp)
    print("sorted=", *comp, "<>", "self=", *test, "equal=", t)
    # print(*test)
    return t


def sort(sub, start, end):
    if start >= end:
        return

    pivot = start
    left, right = start + 1, end

    while left < right:
        while left <= end and sub[left] <= sub[pivot]:
            left += 1
        while right > start and sub[right] >= sub[pivot]:
            right -= 1

        if left > right:
            sub[pivot], sub[right] = sub[right], sub[pivot]
        else:
            sub[left], sub[right] = sub[right], sub[left]

    sort(sub, start, right - 1)
    sort(sub, right + 1, end)


n = 100000
cnt = 0
for _ in range(n):
    if not pr():
        cnt += 1

print(cnt)
