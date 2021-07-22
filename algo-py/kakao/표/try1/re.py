def dw(p, c, n):
    d = int(c.split(' ')[1])
    if p + d < n:
        p = p + d
    else:
        p = n - 1

    return p


def up(p, c):
    u = int(c.split(' ')[1])
    if p - u >= 0:
        p = p - u
    else:
        p = 0

    return p


def solution(n, p, cmd):
    l = [i for i in range(n)]
    st = []

    for c in cmd:
        print(c)
        if c.startswith('U'):
            p -= int(c.split(' ')[1])
        if c.startswith('D'):
            p += int(c.split(' ')[1])
        if c == 'C':
            st.append([l.pop(p), p])
            if p >= len(l):
                p = len(l) - 1
        if c == 'Z' and len(st):
            prev = st.pop()
            l.insert(prev[1], prev[0])
            if prev[1] >= p:
                p += 1
        print(l, st)
        print("pointer =", p)
    a = list(map(lambda x: x[0], st))
    return "".join(['O' if not i in a else 'X' for i in range(n)])


n = 8
k = 2
# cmd = ["D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"]
# cmd = ['D 3', "C", 'C', 'C', 'C', 'U 3', 'Z', 'Z', 'Z', 'Z']

cmd = ['C','Z','D 1', 'C','Z', 'D 2', 'Z', 'U 3', 'Z']
print(solution(n, k, cmd))
