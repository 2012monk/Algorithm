def solution():
    n, k = map(int, input().split())
    m = [0 for _ in range(k + 1)]

    for i in range(n):
        w, v = map(int, input().split())
        for j in reversed(range(w, k + 1)):
            d = m[j - w] + v
            if m[j] < d:
                m[j] = d
    print(m[k])


# if __name__ == '__main__':
#     solution()


def solution_2():
    n, k = map(int, input().split())
    d = {0: 0}

    for _ in range(n):
        w, v = map(int, input().split())
        u = {}
        for dw, dv in d.items():
            t = w + dw
            if t <= k and v + dv > d.get(t, 0):
                u[t] = v + dv
        d.update(u)
    print(max(d.values()))


if __name__ == '__main__':
    solution_2()
