def count(n: int) -> int:
    arr = [0] + [1] * 10

    for _ in range(n):
        print(arr)
        for i in range(1, 11):
            arr[i] += arr[i - 1]
    return arr[10]


print(count(3))
