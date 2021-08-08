from collections import defaultdict


def queen(m: int, n: int):
    if m == n:
        return 1
    r = 0
    for i in range(n):
        if y[i + m] or z[m - i] or v[i]:
            continue
        y[i + m], z[m - i], v[i] = 1, 1, 1
        r += queen(m + 1, n)
        y[i + m], z[m - i], v[i] = 0, 0, 0
    return r


if __name__ == '__main__':
    v = defaultdict(int)
    y = defaultdict(int)
    z = defaultdict(int)
    print(queen(0, int(input())))
