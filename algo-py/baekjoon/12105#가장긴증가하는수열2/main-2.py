from bisect import bisect_left as bs
import sys

In = sys.stdin.readline


def solution(n, arr):
    res = [arr[0]]

    for i in range(1, n):
        if res[-1] < arr[i]:
            res.append(arr[i])
        else:
            res[bs(res, arr[i])] = arr[i]
    return len(res)


if __name__ == '__main__':
    print(solution(int(In()), list(map(int, In().split()))))
