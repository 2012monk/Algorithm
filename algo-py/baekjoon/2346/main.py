n = 5
cmd = [3,2,1,-3,-1]

def solution(n ,cmd):
    l = [i for i in range(1, n + 1)]
    res = [1]
    prev = [n - 1] + [i for i in range(n)] + [0]
    prev, nxt = prev[:-2], prev[2:]
    k = 0

    nxt[prev[0]] = nxt[0]
    prev[nxt[0]] = prev[0]
    for _ in range(n - 1):
        c = cmd[k]
        for _ in range(abs(cmd[k])):
            if c > 0:
                k = nxt[k]
            else:
                k = prev[k]
        res.append(l[k])
        # print(c, k)

        nxt[prev[k]] = nxt[k]
        prev[nxt[k]] = prev[k]

    return res

if __name__ == '__main__':
    n = int(input())
    cmd = list(map(int, input().split()))
    print(*solution(n, cmd))