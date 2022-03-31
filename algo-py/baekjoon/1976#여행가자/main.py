def find(x, u):
    if u[x] < 0:
        return x
    u[x] = find(u[x], u)
    return u[x]


def union(x, y, u):
    a, b = map(find, (x, y), (u, u))
    if a == b:
        return
    if a > b:
        a, b = b, a
    u[b] = a


if __name__ == '__main__':
    n = int(input())
    m = int(input())
    u = [-1 for i in range(n + 1)]
    for i in range(1, n + 1):
        cities = list(map(int, input().split()))
        for j in range(len(cities)):
            if cities[j]:
                union(i, j + 1, u)
    cities = list(map(int, input().split()))
    root = find(cities[0], u)
    if any(find(x, u) != root for x in cities[1:]):
        print('NO')
        exit()
    print('YES')
