def detach(n, arr):
    u = d = t = 0

    for i in range(n):
        u, d, t = max(d, t) + arr[0][i], max(u, t) + arr[1][i], max(u, d)

    return max(u, d, t)


if __name__ == '__main__':
    for _ in range(int(input())):
        print(detach(int(input()), [list(map(int, input().split())) for _ in range(2)]))
