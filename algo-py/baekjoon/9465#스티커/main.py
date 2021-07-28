def detach(arr: list[list[int]], n: int) -> int:
    if n == 1:
        return max(arr[0][0], arr[1][0])
    arr[1][1] += arr[0][0]
    arr[0][1] += arr[1][0]
    for i in range(2, n):
        for j in range(2):
            arr[j][i] += max(arr[j ^ 1][i - 1], arr[j ^ 1][i - 2])

    return max(arr[0][n - 1], arr[1][n - 1])


if __name__ == '__main__':
    for _ in range(int(input())):
        n = int(input())
        a = [list(map(int, input().split())), list(map(int, input().split()))]
        print(detach(a, n))
'''
1
3
100 1 1 
1 1 100 
200
'''
