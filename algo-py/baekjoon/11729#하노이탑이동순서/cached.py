import sys

input = sys.stdin.readline


def cacheable(func):
    cache = {}

    def u(*args):
        if args not in cache:
            cache[args] = func(*args)
        return cache[args]

    return u


@cacheable
def hanoi_cache(n, s=1, e=3):
    if n == 0:
        return ''
    res = ''
    t = 6 - s - e
    res += hanoi_cache(n - 1, s, t)
    res += f'{s} {e}\n'
    res += hanoi_cache(n - 1, t, e)

    return res


if __name__ == '__main__':
    n = int(input())
    print(2 ** n - 1)
    print(hanoi_cache(n))