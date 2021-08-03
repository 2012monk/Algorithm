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


def count(func):
    def __d():
        st = tm()
        r = func()
        print(func.__name__, 'return :', r)
        end = tm()
        print('time :', timedelta(seconds=end - st), 'sec')

    return __d


@count
def test():
    for i in range(int(1e10)):
        i = i
        # print('.',end='')

test()