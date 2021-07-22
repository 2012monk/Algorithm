def solution(N, cmd):
    ll = ['?' for _ in range(N)]
    k = 0
    for c in cmd:
        c = c.split(' ')
        k = (k - int(c[0])) % N
        if ll[k] != '?' or c[1] in ll:
            if ll[k] != c[1]:
                return '!'
        ll[k] = c[1]
    return ''.join([ll[i % N] for i in range(k, k + N)])


if __name__ == '__main__':
    n, s = map(int, input().split())
    print(solution(n, [input() for _ in range(s)]))
