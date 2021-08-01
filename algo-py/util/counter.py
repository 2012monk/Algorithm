import time
from timeit import default_timer as tm
from datetime import timedelta


def measure_time(func, *arg):
    st = tm()
    r = func(*arg)
    print(func.__name__, 'return :', r)
    end = tm()
    print('time :', timedelta(seconds=end - st), 'sec')
    return r

