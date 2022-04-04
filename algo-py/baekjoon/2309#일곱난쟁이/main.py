import sys

ans = []


def comb(cur, path):
    global ans
    if cur >= 9 or len(path) == 2:
        s = total - sum(path)
        if s == 100:
            ans = path[:]
        return
    comb(cur + 1, path + [heights[cur]])
    comb(cur + 1, path)


sys.setrecursionlimit(10 ** 5)

if __name__ == '__main__':
    heights = [int(input()) for _ in range(9)]
    total = sum(heights)
    comb(0, [])
    for h in sorted(heights):
        if h in ans:
            continue
        print(h)
