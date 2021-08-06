# 재귀 구조로 풀어낸 하노이 탑 이동 알고리즘
# n 번 원판은 1 -> 3으로 이동한다
# n - 1 원판은 1 -> 1,2,3 중 시작과 끝이 아닌 장대로 이동한다
def hanoi(n, s=1, e=3):
    if not n:
        return
    o = 6 - s - e
    hanoi(n - 1, s, o)
    print(s, e)
    hanoi(n - 1, o, e)


if __name__ == '__main__':
    n = int(input())
    print((1 << n) - 1)
    hanoi(n)



hanoi(4)
# hanoi_cache(4)
# def hanoi(n, a=1, b=3, res=None):
#     if res is None:
#         res = []
#     if n == 1:
#         res.append((n, a, b))
#         return
#     hanoi(n - 1, a, 6 - a - b, res)
#     res.append((n, a, b))
#     hanoi(n - 1, 6 - a - b, b, res)
#     return res
#
#
# for i, r in enumerate(hanoi(3)):
#     print(f'disk {r[0]} \n {r[1]} -> {r[2]} count {i + 1}')
