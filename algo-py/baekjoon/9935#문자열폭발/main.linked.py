def solution(msg: str, exp: str) -> str:
    l = [-1] + [i for i in range(len(msg) + 1)] + [-1]
    l, r = l[:-2], l[2:]
    b = [0 for _ in range(len(msg))]

    p = 0
    last = 0
    for i in range(len(msg)):

        if msg[i] == exp[p]:
            p += 1
        elif msg[i] == exp[0]:
            p = 1
        else:
            p = 0

        b[i] = p
        if p == len(exp):
            cur = i
            for _ in range(3):
                print(msg[cur], end='')
                cur = l[cur]
            print()
            r[cur] = r[i]
            l[r[i]] = cur
            p = b[cur]
        last = r[i]
    res = []
    p = 0
    while r[p] != -1:
        print(p)
        res.append(msg[p])
        p = r[p]

    return ''.join(res)


m = 'mirkovC4nizCC44'
s = 'C4'

print(solution(m, s))
