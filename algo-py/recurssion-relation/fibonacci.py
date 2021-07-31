import time
from math import *


def fib(n):
    a = 1
    b = 1
    while n - 2:
        a, b = b, a + b
        n -= 1

    return b


def fib2(n):
    k = sqrt(5)
    print(((k + 1) / 2) ** n - ((k - 1) / 2) ** n)
    return (((k + 1) / 2) ** n - ((k - 1) / 2) ** n) / k


def measure_time(func, arg):
    st = time.time()
    print(func(arg))
    end = str(time.time() - st)
    end = end[:4].replace('.', ':') + ':' + end[4:10]
    print(end, 'second')


measure_time(fib, 3)
measure_time(fib2, 2)