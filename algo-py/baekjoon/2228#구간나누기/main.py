from sys import stdin
input = stdin.readline


def solution(n, k, a):
    cache = [[-float('inf') for _ in range(n + 1)] for _ in range(n + 1)]

    def a_split(st, remain):
        if remain < 0:
            return 0
        if st >= n:
            return -float('inf')
        if cache[st][remain] != -float('inf'):
            return cache[st][remain]

        r = [a_split(st + 1, remain)]  # 현재 인덱스를 선택하지 않을때 계산
        s = 0
        for i in range(st, n - (2 * remain)):
            s += a[i]
            r.append(s + a_split(i + 2, remain - 1))

        cache[st][remain] = max(r)
        return cache[st][remain]

    return a_split(0, k - 1)


if __name__ == '__main__':
    n, k = map(int, input().split())
    a = [int(input()) for _ in range(n)]
    print(solution(n, k, a))

n, k = 6, 2
a = [-1, 3, 1, 2, 4, -1]

# n, k = 4, 2
# a = [-1, -1, -99, -10]
# n, k = 9, 4
# a = [i for i in reversed(range(1, 10))]
print(solution(n, k, a))
