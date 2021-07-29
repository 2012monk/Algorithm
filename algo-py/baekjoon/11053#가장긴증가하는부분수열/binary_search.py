import sys

input = sys.stdin.readline


def search(left: int, right: int, target: int, targetArr: list[int]) -> int:
    while left <= right:
        mid = (left + right) // 2
        if targetArr[mid] >= target:
            right = mid - 1
        else:
            left = mid + 1

    return left


def solution(n: int, arr: list[int]) -> int:
    lis = [arr[0]]
    for i in range(1, n):
        if lis[-1] < arr[i]:
            lis.append(arr[i])
        else:
            pos = search(0, len(lis), arr[i], lis)
            lis[pos] = arr[i]

    return len(lis)


if __name__ == '__main__':
    print(solution(int(input()), list(map(int, input().split()))))
