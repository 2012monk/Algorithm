test = "()(((()())(())()))(())"
# test = "(((()(()()))(())()))(()())"
test = test.replace('()', 'A')

import sys
def sol(arr):
    arr = arr.replace('()', 'A')
    t = 0
    res = 0
    for i in arr:
        if i == "(":
            t += 1
        elif i == "A":
            res += t
        else:
            t -= 1
            res += 1
    return res


if __name__ == '__main__':
    print(sol(sys.stdin.readline().rstrip()))
