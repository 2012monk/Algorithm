def count_member(cur, flag):
    count = 1
    d = [[0, 1], [0, -1], [1, 0], [-1, 0]]
    x, y = cur // 5, cur % 5
    selected[x][y] = flag

    for nx, ny in d:
        dx, dy = nx + x, ny + y
        if dx < 0 or dx >= 5 or dy < 0 or dy >= 5:
            continue
        nxt = dx * 5 + dy
        if nxt not in members or selected[dx][dy] == flag:
            continue
        count += count_member(nxt, flag)
    return count


def comb(cur, remain, outer):
    global v
    if 25 - cur < remain or outer > 3:
        return 0
    if remain == 0:
        v += 1
        return +(count_member(members[0], v) == 7)

    ret = 0
    x, y = cur // 5, cur % 5

    members.append(cur)
    ret += comb(cur + 1, remain - 1, outer + (grid[x][y] == 'Y'))
    members.pop()
    ret += comb(cur + 1, remain, outer)
    return ret


if __name__ == '__main__':
    grid = [list(input()) for _ in range(5)]
    members = []
    selected = [[0] * 5 for _ in range(5)]
    v = 1
    print(comb(0, 7, 0))
