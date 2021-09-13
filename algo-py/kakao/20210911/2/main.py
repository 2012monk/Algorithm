def prime(n):
    sieve = [0, 0] + [1 for _ in range(n)]
    for i in range(2, int(n ** 0.5) + 1):
        if sieve[i]:
            for j in range(i + i, n, i):
                sieve[j] = 0
    return sieve


def f(n):
    if n <= 1:
        return 0
    t = int(n**0.5)
    for num in range(2, t + 1):
        if n % num == 0:
            return 0
    return 1

def calc(number, base):
    result = [[]]

    while number > 0:
        s, m = divmod(number, base)
        # m = number % base
        if m == 0:
            if result[-1]:
                result.append([])
        else:
            result[-1].append(m)
        # number = number // base
        number = s

    return result


def assemble(arr):
    if not arr:
        return 0
    length = len(arr)
    result = 0
    for i in range(length):
        result += arr[i] * 10 ** i
    return result


def solution(n, k):
    changed = calc(n, k)
    candidates = []
    for t in changed:
        candidates.append(assemble(t))
    res = 0
    print(candidates)
    if candidates:
        candidates.sort(reverse=True)
        for c in candidates:
            if c > 1:
                res += f(c)
    return res


print(solution(437674, 3))

# print(solution(9, 7))
print(solution(1000000, 9))
# print(solution(1010101100, 10))
#
# print(solution(9890981, 10))

# print(solution(3,3))
# print(solution(98903, 9))
# print(solution(437674, 3))
# print(solution(110011, 10))
