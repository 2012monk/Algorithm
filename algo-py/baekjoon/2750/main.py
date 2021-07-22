# n = int(input())
# l = [int(input()) for _ in range(n)]
import random
import sys

n = 2 ** 3
sys.setrecursionlimit(n * 10)
l = [random.randint(1, n - 1) for _ in range(n)]


# l = [200 for _ in range(n)] + [201]
# quick 정렬

def sort(l, s, e):
    if s >= e:
        return

    p = l[s]
    i, j = s + 1, e

    while i <= j:
        while i <= e and l[i] <= p:
            i += 1
        while j >= 0 and l[j] >= p:
            j -= 1

        if i > j:
            l[s], l[j] = l[j], l[s]
        else:
            l[i], l[j] = l[j], l[i]

    sort(l, s, j - 1)
    sort(l, j + 1, e)


sort(l, 0, n - 1)

print(l)
