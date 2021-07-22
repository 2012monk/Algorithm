case = "<<BP<A>>Cd-"
case = "ThIsIsS3Cr3t"
case = "cd>>----ab<t>c"

import sys
def solution(case):
    pad = []
    p = 0
    for s in case:
        if s == '<':
            if p > 0:
                p -= 1
        elif s == '>':
            if len(pad) > p:
                p += 1
        elif s == '-':
            if pad and p > 0:
                p -= 1
                pad.pop(p)
        else:
            pad.insert(p, s)
            p += 1
    pad.append("\n")
    return "".join(pad)


if __name__ == '__main__':
    # print(solution(case))
    for _ in range(int(sys.stdin.readline().rstrip())):
        sys.stdout.write(solution(sys.stdin.readline().rstrip()))
