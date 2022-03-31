def solution(stones_orig, k):
    res = []
    v = set()
    v.add(tuple(stones_orig))
    sorted_stones = sorted(stones_orig)
    mx, sc = sorted_stones[0], sorted_stones[1]

    def solve(stones, path):
        if len(path) > limit:
            return
        filtered = list(filter(lambda x: x != 0, stones))
        if len(filtered) == 0:
            if filtered[0] == k:
                res.append(path)
        for i in range(len(stones)):
            if stones[i] >= 12:
                continue
            print(v)
            tmp = list(map(lambda x: max(0, x - 1), stones))
            tmp[i] += 2
            if tuple(tmp) in v:
                continue
            v.add(tuple(tmp))
            solve(tmp, path + str(i))

    solve(stones_orig, "")

    if not res:
        return -1
    return sorted(res)[:-1]


print(solution(
    [1, 3, 2], 3))
