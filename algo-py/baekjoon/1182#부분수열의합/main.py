
def track(arr, i, r, t):
    if i == len(arr):
        if r == t:
            return 1
        else:
            return 0
    result = 0
    result += track(arr, i + 1, r + arr[i], t)
    result += track(arr, i + 1, r, t)

    return result


def solution(arr, target):
    r = track(arr, 0, 0, target)
    if target == 0:
        r -= 1
    print(r)


# if __name__ == '__main__':
#     n, t = map(int, input().split())
#     solution(list(map(int, input().split())), t)


t = 0
tc = [-7, -3, -2, 8, 5]

sol_permute(tc, t)
solution(tc, t)
