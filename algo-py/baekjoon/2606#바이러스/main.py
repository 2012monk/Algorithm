def find(x, uf):
    if uf[x] != x:
        uf[x] = find(uf[x], uf)
    return uf[x]


def union(x, y, uf):
    a = find(x, uf)
    b = find(y, uf)
    if a == b:
        return
    if a < b:
        a, b = b, a
    uf[a] = uf[b]


if __name__ == '__main__':
    n = int(input())
    m = int(input())
    u = [i for i in range(n + 1)]
    for _ in range(m):
        x, y = map(int, input().split())
        union(x, y, u)
    root, result = find(1, u), 0
    for i in range(2, n + 1):
        result += +(find(i, u) == root)
    print(result)
