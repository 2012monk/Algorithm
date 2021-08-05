def solution(n: int):
    dp = {1: 0, 2: 1, 3: 1}
    trace = {3: 1, 2: 1}

    def track(k) -> int:
        if k in dp.keys():
            return dp[k]

        m, idx = track(k // 3) + k % 3, 3
        s, j = track(k // 2) + k % 2, 2
        if m > s:
            m, idx = s, j

        for i in range(k % idx):
            trace[k - i] = k - i - 1
        trace[k - k % idx] = k // idx
        dp[k] = m + 1
        return dp[k]

    print(track(n))
    res = [n]
    while n != 1:
        n = trace[n]
        res.append(n)

    print(*res)


# solution(int(input()))

for i in range(5, 20):
    print(i, end=':   ')
    solution(i)
