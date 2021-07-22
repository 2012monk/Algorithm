from collections import deque
import sys


def solution(ap, cmds, N):
    t = 0
    l = [0, 1]
    body = deque([[0, 0]])
    cmd = {}

    for c in cmds:
        op = c.split(' ')
        cmd[int(op[0])] = op[1]
    while 1:
        t += 1
        # 기존 head 에 진행연산
        # head = list(map(lambda x: x[0] + x[1], zip(l, body[0])))
        head = [body[0][0] + l[0], body[0][1] + l[1]]

        # 종료조건
        if head in body:
            break
        if head[0] not in range(N) or head[1] not in range(N):
            break

        body.appendleft(head)

        if head not in ap:
            body.pop()
        else:
            ap.remove(head)

        # rotation matrix
        if t in cmd.keys():
            if cmd[t] == 'D':
                l = [l[1], -l[0]]
            if cmd[t] == 'L':
                l = [-l[1], l[0]]
    return t


if __name__ == '__main__':
    N = int(input())
    ap = []
    cmd = []
    for _ in range(int(input())):
        ap.append(list(map(int, sys.stdin.readline().rstrip().split())))

    ap = list(map(lambda x: [x[0] - 1, x[1] - 1], ap))
    for _ in range(int(input())):
        cmd.append(sys.stdin.readline().rstrip())
    print(solution(ap, cmd, N))
