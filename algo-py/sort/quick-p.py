import random

n = 2 ** 3

# test = [random.randint(1, n) for _ in range(n)]
test = [5, 1, 3, 7, 6, 1, 2, 6]
test = [1, 1, 1, 1, 4, 8, 3, 1]


# n = 4
# test = [1, 1, 1, 3]
# n = 5
# test = [5, 3, 1, 4, 2]

def sort(li, s, e):
    print("start is %d end is %d", s, e)
    print(li, "\n")
    if s >= e:
        return
    p = s
    left, right = s + 1, e

    while left <= right:
        while left <= e and li[left] <= li[p]:
            left += 1
        while right > s and li[right] >= li[p]:
            right -= 1

        if left > right:
            li[right], li[p] = li[p], li[right]
        else:
            li[left], li[right] = li[right], li[left]
        print(*li)
    sort(li, s, right - 1)
    sort(li, right + 1, e)


sort(test, 0, n - 1)
print(*test)
