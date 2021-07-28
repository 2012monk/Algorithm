def solution(n: int) -> int:
    a = [1] * 10
    b = [0] * 10

    s = 10

    for _ in range(1, n):
        b[0] = s
        for i in range(1, 10):
            b[i] = (b[i - 1] - a[i - 1]) % 10007
            s += b[i]

        a = b[:]
    return s % 10007


if __name__ == '__main__':
    print(solution(int(input())))
    # print(solution(4))
