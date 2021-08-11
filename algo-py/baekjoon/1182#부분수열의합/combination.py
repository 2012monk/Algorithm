from itertools import combinations


def sol_permute(arr, target):
    r = 0
    for i in range(1, len(arr) + 1):
        for p in combinations(arr, i):
            print(p)
            if sum(p) == target:
                r += 1
    print(r)


if __name__ == '__main__':
    n, t = map(int, input().split())
    sol_permute(list(map(int, input().split())), t)