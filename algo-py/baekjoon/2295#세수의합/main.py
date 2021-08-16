import bisect


def comb(arr):
    s = []
    for i in range(len(arr)):
        for j in range(i, len(arr)):
            s.append(arr[i] + arr[j])
    s.sort()
    return s


def solution(arr):
    arr.sort()
    s = comb(arr)
    for i in range(len(arr) - 1, -1, -1):
        for j in reversed(range(i)):
            k = bisect.bisect_left(s, arr[i] - arr[j])
            if k < len(s) and s[k] == arr[i] - arr[j]:
                return arr[i]


if __name__ == '__main__':
    a = [int(input()) for _ in range(int(input()))]
    print(solution(a))
