a = [1, 2, 5]

b = ['O' if i not in a else 'X' for i in range(10)]

# print("".join(b))

n = 8
k = 2
cmd = ["D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"]


def dw(p, c, l):
    d = int(c.split(' ')[1])
    if p + d < l:
        p = p + d
    else:
        p = l - 1

    return p


def up(p, c):
    u = int(c.split(' ')[1])
    if p - u >= 0:
        p = p - u
    else:
        p = 0

    return p


def solution(n, p, cmd):
    o = n
    st = []
    l = [[i, i + 1] for i in range(n)]
    l[-1][1] = -1

    for c in cmd:
        if c.startswith('U'):
            p = up(p, c)
        if c.startswith('D'):
            p = dw(p, c, n)
        if c == 'Z':
            c = st.pop()
            l[c[0] - 1][1] = c[0]
            n += 1
            if c[0] <= p:
                p += 1
        if c == 'C':
            if p > 0:
                l[p - 1][1] += 1

            st.append(l[p])
            n -= 1
            if p > n - 1:
                p = n - 1

    # a = list(map(lambda x: x[0], st))
    return "".join(['O' if i not in st else 'X' for i in range(o)])


print(solution(n, k, cmd))
