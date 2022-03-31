import sys


def find(x):
    if data[x] != x:
        data[x] = find(data[x])
    return data[x]


def union(x, y):
    a, b = map(find, (x, y))
    if a == b:
        return
    data[b] = a
    count[a] += count[b]


input = sys.stdin.readline

if __name__ == '__main__':
    n = int(input())
    for _ in range(n):
        data = {}
        count = {}
        m = int(input())
        for _ in range(m):
            n1, n2 = input().split()
            if n1 not in data:
                data[n1] = n1
                count[n1] = 1
            if n2 not in data:
                data[n2] = n2
                count[n2] = 1
            union(n1, n2)
            print(count[find(n1)])
