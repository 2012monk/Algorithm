def search(a, t):
    l, r = 0, len(a)
    while l < r:
        mid = (l + r) // 2
        if a[mid] < t:
            l = mid + 1
        elif a[mid] > t:
            r = mid
        else:
            return mid
    return -1


def solution(arr: list[int], m: list[int]) -> str:
    arr.sort()
    res = []
    for k in m:
        if search(arr, k) != -1:
            res.append('1')
        else:
            res.append('0')
    return '\n'.join(res)


if __name__ == '__main__':
    n = int(input())
    a = list(map(int, input().split()))
    m = int(input())
    li = list(map(int, input().split()))
    print(solution(a, li))
