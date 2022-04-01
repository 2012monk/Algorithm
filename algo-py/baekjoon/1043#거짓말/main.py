import sys


def union(x, y):
    x, y = map(find, (x, y))
    if x == y:
        return
    if x > y:
        x, y = y, x
    s[y] = x


def unionAll(people):
    root = people[0]
    for p in people[1:]:
        union(root, p)


def find(x):
    if s[x] < 0:
        return s[x]
    if s[x] != x:
        s[x] = find(s[x])
    return s[x]


input = sys.stdin.readline
if __name__ == '__main__':
    n, m = map(int, input().split())
    k = list(map(int, input().split()))[1:]

    s = [i for i in range(n + 1)]
    for p in k:
        s[p] = -1
    groups = []
    for _ in range(m):
        people = list(map(int, input().split()))[1:]
        groups.append(people)
        unionAll(people)

    r = 0
    for g in groups:
        if any(find(x) == -1 for x in g):
            continue
        r += 1
    print(r)
