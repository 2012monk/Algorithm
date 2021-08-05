
from util.counter import Count

test = int(1e8)
@Count
def range_test():
    x = range(10)
    r = 0
    for i in range(test):
        if i in x:
            r = ~r

@Count
def op_test():
    r = 0

    for i in range(test):
        if 0 <= i < 10:
            r = ~r


range_test()
op_test()
