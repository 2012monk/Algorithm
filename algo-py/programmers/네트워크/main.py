def find(x, s):
    if s[x] != x:
        s[x] = find(s[x], s)
    return s[x]


def union(x, y, s):
    x = find(x, s)
    y = find(y, s)
    if x == y:
        return
    if x < y:
        x, y = y, x
    s[x] = y


def solution(n, computers):
    s = [i for i in range(n)]
    for i in range(len(computers)):
        for j in range(len(computers[0])):
            if computers[i][j]:
                union(i, j, s)
    for i in range(n):
        find(i, s)
    return len(set(s))
