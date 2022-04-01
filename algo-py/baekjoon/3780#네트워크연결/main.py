import sys

sys.setrecursionlimit(10 ** 7)
input = sys.stdin.readline


def find(x):
    if uf[x] < 0:
        return x
    root = find(uf[x])
    dist[x] += dist[uf[x]]
    uf[x] = root
    return uf[x]


def connect(a, b):
    dist[a] = abs(a - b) % 1000
    uf[a] = b


if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        n = int(input())
        uf = [-1] * (n + 1)
        dist = [0] * (n + 1)
        while 1:
            cmds = input().split()
            cmd = cmds[0]
            if cmd == 'O':
                break
            if cmd == 'E':
                x = int(cmds[1])
                find(x)
                print(dist[x])
            else:
                connect(*map(int, cmds[1:]))
