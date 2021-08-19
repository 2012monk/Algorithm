import sys

input = sys.stdin.readline


def solution(arr, target):
    r = 0
    while target:
        c = arr.pop()
        r += target//c
        target %= c
    return r


if __name__ == '__main__':
    n, t = map(int, input().split())
    a = [int(input()) for _ in range(n)]
    print(solution(a, t))
