def solution(n, arr):
    for i in range(1, n):
        arr[i][0] += arr[i - 1][0]
        arr[i][-1] += arr[i - 1][-1]

        for j in range(1, i):
            arr[i][j] += max(arr[i - 1][j - 1], arr[i - 1][j])

    return max(arr[-1])


if __name__ == '__main__':
    n = int(input())
    t = [list(map(int, input().split())) for _ in range(n)]

    print(solution(n, t))
