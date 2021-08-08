def queen(m: int, n: int):
    if m == n:
        return 1
    r = 0
    t = n if m else n // 2

    for i in range(t):
        if y[i + m] or z[m - i] or v[i]:
            continue
        y[i + m] = z[m - i] = v[i] = 1
        r += queen(m + 1, n)
        y[i + m] = z[m - i] = v[i] = 0
    r = r if m else r * 2
    if n % 2 == 1 and m == 0:
        v[n // 2] = y[n // 2] = z[-(n // 2)] = 1
        r += queen(m + 1, n)
        v[n // 2] = y[n // 2] = z[-(n // 2)] = 0

    return r


if __name__ == '__main__':
    v = [0] * 40
    y = [0] * 40
    z = [0] * 40
    print(queen(0, int(input())))
