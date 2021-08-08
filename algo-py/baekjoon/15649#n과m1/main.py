def track(cand, m, path=[], res=[]):
    if m == 0:
        res.append(path)
        return
    for i in range(len(cand)):
        track(cand[:i] + cand[i + 1:], m - 1, path + [cand[i]], res)
    return res

def solution():
    n, m = map(int, input().split())
    c = [i for i in range(1, n + 1)]
    for p in track(c, m):
        print(*p)


if __name__ == '__main__':
    solution()

'''test code
tc = [i for i in range(1, 5)]
print(track(tc, 2))
n=4 m=2
1 2
1 3
1 4
2 1
2 3
2 4
3 1
3 2
3 4
4 1
4 2
4 3
'''
