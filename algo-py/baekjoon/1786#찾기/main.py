import sys

input = sys.stdin.readline


def getTable(p, m):
    t = [0] * m
    j = 0
    for i in range(1, m):
        while j > 0 and p[i] != p[j]:
            j = t[j - 1]
        if p[i] == p[j]:
            t[i] = j = j + 1
    return t


def solution(case, target):
    j, m = 0, len(target)
    t = getTable(target, m)

    res = []
    for i in range(len(case)):
        while j > 0 and case[i] != target[j]:
            j = t[j - 1]
        if case[i] == target[j]:
            j += 1
        if j == m:
            res.append(i - m + 1 + 1)
            j = t[j - 1]
    return res


if __name__ == '__main__':
    text = input().replace('\n', '')
    target = input().replace('\n', '')
    r = solution(text, target)
    print(len(r))
    print(' '.join(map(str, r)))
