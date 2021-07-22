# S, N = 10, 3
# cmd = [2, 9, 5]
# cmd = [1, 2, 3]
#
# S, N = 32, 6
# cmd = [27, 16, 30, 11, 6, 23]
# S, N = 10, 10
# cmd = [1, 6, 3, 2, 7, 9, 8, 4, 10, 5]
# S, N = 5, 5
# cmd = [1, 2, 5, 4, 3]
S, N = 9, 5
cmd = [5, 1, 4, 2, 3]


def solution(S, N, cmd):
    nxt = [i for i in range(1, S)] + [0]
    prev = [S - 1] + [i for i in range(0, S - 1)]
    k = 0
    r = 0
    size = S
    for i in range(N):
        c = cmd[i] - 1
        t = 0
        while k != c:
            k = nxt[k]
            t += 1
        if t > size // 2:
            r += size - t
        else:
            r += t
        nxt[prev[k]] = nxt[k]
        prev[nxt[k]] = prev[k]

        k = nxt[k]
        size -= 1
    return r


# if __name__ == '__main__':
#     S, N = map(int, input().split())
#     cmd = list(map(int, input().split()))
#     print(solution(S, N, cmd))

print(solution(S, N, cmd))
