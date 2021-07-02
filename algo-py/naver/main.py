def f(h):
    if h == 0:
        return
    f(h - 1)
    for i in range(h):
        print('#', end='')
    print()

f(5)


def v(h):
    for i in range(h):
        for j in range(i):
            print("3", end='')
        print()



v(5)