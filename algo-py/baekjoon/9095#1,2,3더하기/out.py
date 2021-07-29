t = int(input())
for i in range(t):
    n = int(input())
    d = [1, 2, 4] + [0 for _ in range(n - 3)]
    for i in range(3, n):
        d[i] = d[i - 1] + d[i - 2] + d[i - 3]

    print(d[n-1])


