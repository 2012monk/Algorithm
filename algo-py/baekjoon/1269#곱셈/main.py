import sys


# sys.setrecursionlimit(10 ** 5)


def solution(a, p, m):
    if p == 1:
        return a % m
    v = solution(a, p // 2, m) ** 2 % m
    if not p & 1:
        return v
    return v * a % m

if __name__ == '__main__':
    print(solution(*map(int, input().split())))

print(solution(12, 116, 67))
