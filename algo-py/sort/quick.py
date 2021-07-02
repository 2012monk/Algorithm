import random

n = 2 ** 5
unsorted = [random.randint(1, n) for _ in range(n)]


def quick(l, st, end):
    if st >= end:
        return

    p = st

    i, j = st + 1, end

    while i <= j:
        while i <= end and l[i] <= l[p]:
            i += 1

        while j >= 0 and l[j] >= l[p]:
            j -= 1

        if i > j:
            l[p], l[j] = l[j], l[p]
        else:
            l[i], l[j] = l[j], l[i]

    quick(l, st, j - 1)
    quick(l, j + 1, end)


quick(unsorted, 0, n - 1)

print(unsorted)
