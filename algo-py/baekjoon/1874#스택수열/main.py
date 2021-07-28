def solution(n, sequence: list):
    l = []
    r = [n - i + 1 for i in range(1, n + 1)]
    res = []
    for s in sequence:
        while r and r[-1] <= s:
            l.append(r.pop())
            res.append('+')

        while l and l[-1] > s:
            l.pop()
            res.append('-')

        if l and l[-1] == s:
            res.append('-')
            l.pop()
        else:
            return ['NO']

    return res


if __name__ == '__main__':
    n = int(input())
    seq = []

    for _ in range(n):
        seq.append(int(input()))

    print('\n'.join(solution(n, seq)))

