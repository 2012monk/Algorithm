input = 4

list = [3,4,5,6, 7, 10]


def dp(n: int):
    d = [1, 2, 4] + [0 for _ in range(n - 3)]
    for i in range(3, n):
        d[i] = d[i - 1] + d[i - 2] + d[i - 3]

    print(d[n-1])

for i in list:
    dp(i)
