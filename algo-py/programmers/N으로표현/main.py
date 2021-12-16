def solution(N, number):
    dp = []

    for i in range(1, 9):
        tmp = set([int(str(N) * i)])
        for j in range(0, i - 1):
            for x in dp[j]:
                for y in dp[-j - 1]:
                    tmp.add(x + y)
                    tmp.add(x - y)
                    tmp.add(x * y)
                    if y != 0:
                        tmp.add(x // y)
        if number in tmp:
            return i + 1
        dp.append(tmp)
    return -1



