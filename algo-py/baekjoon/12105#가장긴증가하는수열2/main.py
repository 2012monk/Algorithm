# 직접 바이너리서치 구현 3500ms
def search(t, arr):
    l = 0
    r = len(arr) - 1

    while l <= r:
        m = (l + r) // 2
        if arr[m] >= t:
            r = m - 1
        else:
            l = m + 1

    return l


def solution(n, arr):
    ll = [arr[0]]

    for i in range(1, n):
        if ll[-1] < arr[i]:
            ll.append(arr[i])

        else:
            ll[search(arr[i], ll)] = arr[i]
    return len(ll)


if __name__ == '__main__':
    print(solution(int(input()), list(map(int, input().split()))))
