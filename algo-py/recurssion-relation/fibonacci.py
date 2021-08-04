import time
import sys

import numpy as np

sys.setrecursionlimit(10 ** 6)


def fib(n):
    a = 1
    b = 1
    while n - 2:
        a, b = b, a + b
        n -= 1

    return b


def fib2(n):
    dp = [0, 1] + [0] * n

    def r(k):
        if k <= 1:
            return k
        if not dp[k]:
            dp[k] = r(k - 1) + r(k - 2)
        return dp[k]

    return r(n)


def fib3(n):
    m = np.matrix([[0, 1], [1, 1]])
    vec = np.array([[0], [1]])

    return np.matmul(m ** n, vec)[0]


def measure_time(func, arg):
    st = time.time()
    print(func(arg))
    end = str(time.time() - st)
    end = end[:4].replace('.', ':') + ':' + end[4:10]
    print(end, 'second')


measure_time(fib, 1000)
measure_time(fib2, 1000)
measure_time(fib3, 1000)
