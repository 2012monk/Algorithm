n = 5

test = [5, 4, 4, 4, 1]


def swap(arr, a, b):
    arr[a], arr[b] = arr[b], arr[a]


def sort(li, s, e):
    if s >= e:
        return

    p = s
    l, r = s + 1, e

    while l <= r:
        while l <= e and li[l] <= li[p]:
            l += 1
        while r > s and li[r] >= li[p]:
            l -= 1

        if l > r:
            swap(li, p, r)
        else:
            swap(li, l, r)

    sort(li, s, r - 1)
    sort(li, r + 1, e)


sort(test, 0, n - 1)

print(test)
