import sys

input = sys.stdin.readline


def solution(arr):
    arr.sort(key=lambda x: (x[1], x[0]))
    t = cnt = 0
    for a in arr:
        if t <= a[0]:
            t = a[1]
            cnt += 1
    return cnt


if __name__ == '__main__':
    print(solution([list(map(int, input().split())) for _ in range(int(input()))]))
