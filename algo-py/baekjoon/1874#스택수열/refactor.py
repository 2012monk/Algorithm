import sys

input = sys.stdin.read


def solution() -> str:
    l = r = 0
    res = []
    # n, *seq = map(int, input().split())
    n = 8
    seq = [4, 3, 6, 8, 7, 5, 2, 1]
    for i in seq:
        print(l, r)
        if r < i:
            res += ['+'] * (i - r)
            l = r = i

        if i <= l:
            res.append('-')
            l = i
        else:
            return 'NO'

    return '\n'.join(res)


if __name__ == '__main__':
    print(solution())
