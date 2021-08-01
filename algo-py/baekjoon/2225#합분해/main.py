import math


# k1, + k2 .... + k(r) = n 부정방정식의 해의 갯수
# r - 1 개의 요소를 n 번 중복조합
# (n + r - 1)H(r-1)

def nHr(n, r):
    f = math.factorial
    return f(n + r - 1) // f(n) // f(r - 1) % 1e9


if __name__ == '__main__':
    n, r = map(int, input().split())
    print(nHr(n, r))


def solution(n, r):
    dp = [0] * 201
