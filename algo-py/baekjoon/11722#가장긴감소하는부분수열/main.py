# binary search
def find(l, r, t, arr):
    while l <= r:
        m = (l + r) // 2
        if arr[m] > t:
            l = m + 1
        else:
            r = m - 1

    return l


def solution(n, arr):
    res = [arr[0]]
    for i in range(1, n):
        # 오름차순으로 정렬이 되면 삽입
        if res[-1] > arr[i]:
            res.append(arr[i])
        else:  # 마지막 값보다 클 경우 자신보다 작은수의 최댓값 자리를 찾는다
            res[find(0, len(res) - 1, arr[i], res)] = arr[i]
    return len(res)  # 수열의 길이


if __name__ == '__main__':
    print(solution(int(input()), list(map(int, input().split()))))

# test code
x = 6
a = [10, 30, 10, 20, 20, 10]
print(solution(x, a))
