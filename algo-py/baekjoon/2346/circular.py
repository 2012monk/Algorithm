def solution(n, cmd):
    k = 0
    res = []
    cor = list(enumerate(cmd))
    while 1:
        m, c = cor.pop(k)
        res.append(m + 1)

        if not cor: break
        if c > 0:
            k = (c + k - 1) % len(cor)
        else:
            k = (c + k) % len(cor)

    return res


n = 5
cmd = [3, 2, 1, -3, -1]

print(solution(n, cmd))
