import sys

input = sys.stdin.readline


def getFailure(cand):
    t, j = [0] * len(cand), 0
    for i in range(1, len(cand)):
        while j > 0 and cand[i] != cand[j]:
            j = t[j - 1]
        if cand[i] == cand[j]:
            j += 1
            t[i] += j
    return t


def check(text, p, f):
    j = 0
    for i in range(len(text)):
        while j > 0 and text[i] != p[j]:
            j = f[j - 1]
        if text[i] == p[j]:
            j += 1
        if j == len(p):
            return True
    return False


def solution(codes, k):
    for i in range(len(codes[0]) - k + 1):
        sub = codes[0][i:i + k]
        f = getFailure(sub)
        for j in range(1, len(codes)):
            c = codes[j]
            if not check(c, sub, f):
                if not check(c[::-1], sub, f):
                    break
            if j == len(codes) - 1:
                return True
    return False


if __name__ == '__main__':
    r = open(0).read().strip().split('\n')
    n, k = map(int, r[0].split())
    arr = [list(map(int, r[s].split())) for s in range(2, len(r), 2)]
    print('YES' if solution(arr, k) else 'NO')

'''
2 4
10
1 2 3 4 15 16 17 18 19 20
10
1 1 2 3 4 25 26 27 28 29
'''

n, k = 3, 4

tc1 = [10, 8, 23, 93, 21, 42, 52, 22, 13, 1, 2, 3, 4]

tc2 = [1, 3, 8, 9, 21, 42, 52, 22, 13, 41, 42]

tc3 = [9, 21, 42, 52, 13, 22, 52, 42, 12, 21]

# print(pattern(tc1, tc2, k))
tcs = [tc1, tc2, tc3]
# print(solution(tcs, k))
