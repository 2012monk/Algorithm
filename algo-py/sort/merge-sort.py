import random


def merge(arr1, arr2):
    l, r = 0, 0
    tmp = []
    while 1:
        if l == len(arr1):
            tmp.extend(arr2[r:])
            break
        if r == len(arr2):
            tmp.extend(arr1[l:])
            break

        if arr1[l] < arr2[r]:
            tmp.append(arr1[l])
            l += 1
        else:
            tmp.append(arr2[r])
            r += 1
    return tmp


def mergeSort(arr):
    if len(arr) == 1:
        return arr
    mid = len(arr) // 2
    return merge(mergeSort(arr[:mid]), mergeSort(arr[mid:]))


a = [8, 7, 6, 5, 4, 3, 10]

print(mergeSort(a))
n = 1 << 20
print(n)
# print(1 << 20)
# a = [chr(random.randint(65, 65 + 26)) for _ in range(n)]
# print(mergeSort(a))
