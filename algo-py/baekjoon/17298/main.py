# n = 4
# test = [3,5,2,7]

n = 6
test = [1,2,3,4,1,5]
test = [4,3,2,1,2,1]
test = [2,2,2,2,1,2]
test = [1,2,2,3,4,5]
n = 2
test = [1, 2]
def solution(n, test):
    stk = []
    for i in range(n):
        cur = test[-i-1]
        while stk and stk[-1] <= cur:
            stk.pop()
        test[-i-1] = stk[-1] if stk else -1
        stk.append(cur)
    return test

if __name__ == '__main__':
    # n = int(input())
    # test = list(map(int, input().split(" ")))
    print(*solution(n, test))

