def find(x, s):
    if s[x] != x:
        s[x] = find(s[x], s)
    return s[x]


def isUnion(x, y, s):
    x = find(x, s)
    y = find(y, s)
    return x == y


def union(x, y, s):
    x = find(x, s)
    y = find(y, s)
    if x < y:
        x, y = y, x
    s[x] = y


def solution(n, costs):
    ans = 0
    uf = [i for i in range(n + 1)]
    costs.sort(key=lambda data: data[2])
    for x, y, c in costs:
        if not isUnion(x, y, uf):
            union(x, y, uf)
            ans += c
    return ans
