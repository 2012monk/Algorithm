def solution(n, arr):
    r = arr[0]
    t = r
    for i in range(1, n):
        print(r)
        r = max(arr[i], r + arr[i])
        t = max(t, r)
    return t
if __name__ == '__main__':
    print(solution(int(input()), list(map(int, input().split()))))

t = 10
test = [10, -4, 3, 1, 5, 6, -35, 12, 21, -1]

print(solution(t, test))