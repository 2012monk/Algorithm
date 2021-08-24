def solution(n):
    a, b = 1, 1
    while n - 2 > 0:
        a, b = a + b, a
        n -= 1
    return a


if __name__ == '__main__':
    print(solution(int(input())))
