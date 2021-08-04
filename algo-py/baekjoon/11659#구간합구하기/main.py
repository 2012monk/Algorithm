import sys

input = sys.stdin.readline


def solution(s, n, m):
    for i in range(1, n + 1):
        s[i] += s[i - 1]

    for _ in range(m):
        i, j = map(int, input().split())
        print(s[j] - s[i - 1])


if __name__ == '__main__':
    n, m = map(int, input().split())
    solution([0] + list(map(int, input().split())), n, m)
