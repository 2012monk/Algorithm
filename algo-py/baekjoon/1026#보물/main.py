def solution(A, B):
    A.sort()
    B.sort()
    return sum(map(lambda a, b: a * b, A, B[::-1]))


if __name__ == '__main__':
    n = int(input())
    arr1 = list(map(int ,input().split()))
    arr2 = list(map(int, input().split()))
    print(solution(arr1, arr2))
