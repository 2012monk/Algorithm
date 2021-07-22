from collections import deque


# def solution(n, k):
#     r = deque([i for i in range(1, n + 1)])
#     l = deque([])
#     res = []
#     while not l and r:
#         for _ in range(k):
#             if len(r) >= k:
#                 l.append(r.popleft())
#
#
#
#     return "<" + ", ".join(res) + ">"

def solution(n, k):
    l = [i + 1 for i in range(n)]
    res = []
    p = 0
    while len(l):
        p = (p + k - 1) % (len(l))
        res.append(l.pop(p))
    print("<"+ ", ".join(list(map(str, res))) + ">")

if __name__ == '__main__':
    n, k = map(int, input().split())
    solution(n, k)




