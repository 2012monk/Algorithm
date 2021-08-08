def solution(n, m):
    path = []

    def track(k):
        if k == m:
            print(*path)
            return
        for i in range(1, n + 1):
            if i not in path:
                path.append(i)
                track(k + 1)
                path.pop()

    track(0)


if __name__ == '__main__':
    solution(*map(int, input().split()))