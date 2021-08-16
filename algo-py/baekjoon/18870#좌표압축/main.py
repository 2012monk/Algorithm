import bisect as bs


def solution(arr):
    a = sorted(set(arr))
    for k in arr:
        print(bs.bisect_right(a, k) - 1, end=' ')


if __name__ == '__main__':
    input()
    solution(list(map(int, input().split())))
