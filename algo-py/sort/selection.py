def selectionSort(arr) -> None:
    print(f'Array length of {len(arr)}')
    compare = 0
    exch = 0
    for i in range(len(arr)):
        smallest = i
        for j in range(i, len(arr)):
            compare += 1
            if arr[j] < arr[smallest]:
                smallest = j
        exch += 1
        arr[i], arr[smallest] = arr[smallest], arr[i]
    print(f'compare count {compare} \nexch count {exch}')
a=[]
sorted([], key=a[0])


def isSorted(arr) -> bool:
    for i in range(1, len(arr)):
        if arr[i - 1] > arr[i]:
            return False

    return True


A = [9, 5, 12, 3, 6, 4, 1, 2, 3, 4]

print(*A)
selectionSort(A)
print(isSorted(arr=A))
print(*A)
