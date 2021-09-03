def find(arr, target, hi, lo=0):
    while lo <= hi:
        mid = (lo + hi) // 2
        if arr[mid] < target:  # 역정렬 되어있는 배열이므로 일반적인 이분탐색과 반대로 인덱스 조정
            hi = mid - 1
        else:
            lo = mid + 1
    return hi


def solution(bucket, pizza, depth, n):
    for i in range(1, depth):  # 들어갈수 있는 사이즈 조정
        if bucket[i] > bucket[i - 1]:
            bucket[i] = bucket[i - 1]

    hi = depth
    for i in range(n):
        hi = find(a, pizza[i], hi-1)  # 이분탐색으로 target 보다 큰 수중 가장 오른쪽 인덱스 검색
        if hi < 0:
            return hi + 1
    return hi + 1  # 인덱스 + 1


if __name__ == '__main__':
    d, n = map(int, input().split())
    a = list(map(int, input().split()))
    j = list(map(int, input().split()))
    print(solution(a, j, d, n))
