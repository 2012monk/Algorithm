n = 5

test = [5, 2, 2, 2, 3]


def swap(arr, a, b):
    arr[a], arr[b] = arr[b], arr[a]


def sort(arr, s, e):
    if s >= e:
        return
    p = s
    l, r = s + 1, e
    print(*arr)
    while l < r:
        while l <= e and arr[l] <= arr[p]:
            l += 1
        while r >= s and arr[r] >= arr[p]:
            r -= 1

        if l > r:
            swap(arr, p, r)
        else:
            swap(arr, l, r)

    sort(arr, s, r - 1)
    sort(arr, r + 1, e)


sort(test, 0, n - 1)
print(*test)
