cache = {0: 0, 1: 0, 2: 1, 3: 1}  # 메모이제이션
# 1을 0 으로 두어야 cache[n] + 1 했을때 1이된다.


def solve(n):
    if n in cache:
        return cache[n]
    print(f'func({n}) called')
    # 모듈러 연산으로 나머지 (2,3 으로 나누어 질때까지 빼주어야 하는 만큼) 더해준다
    cache[n] = min(solve(n // 2) + n % 2, solve(n // 3) + n % 3) + 1
    return cache[n]

if __name__ == '__main__':
    print(solve(int(input())))

print(solve(20))

#
# res = []
# for i in range(1, 20):
#     res.append(solve(i))

ans = [2
    , 3
    , 2
    , 3
    , 3
    , 2
    , 3
    , 4
    , 3
    , 4
    , 4
    , 4
    , 4
    , 5
    , 3
    , 4]
# print(ans == res)
