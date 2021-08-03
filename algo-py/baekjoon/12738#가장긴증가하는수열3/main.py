import sys
from bisect import bisect_left as bs

input = sys.stdin.readline


def solution(arr):
    lis = []

    for t in arr:
        if not lis or lis[-1] < t:
            lis.append(t)
        else:
            lis[bs(lis, t)] = t
    return len(lis)


if __name__ == '__main__':
    n = int(input())
    print(solution(list(map(int, input().split()))))
