def solution(n):
    dp = [0, 1, 1, 1] + [0] * n
    li = [0, 1, 1, 1]

    for i in range(4, n + 1):
        t = {}

        if i % 2 == 0:
            t[dp[i // 2]] = i // 2

        if i % 3 == 0:
            t[dp[i // 3]] = i // 3

        t[dp[i - 1]] = i - 1

        m = min(t)
        li.append(t[m])
        dp[i] = m + 1
    r = [n]
    while n > 1:
        r.append(li[n])
        n = li[n]
    return r


if __name__ == '__main__':
    r = solution(int(input()))
    print(len(r) - 1)
    print(*r)
