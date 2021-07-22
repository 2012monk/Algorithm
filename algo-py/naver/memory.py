from collections import deque
d = deque([])
# d.popleft()
a = ["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"]

for i in range(5):
    for j in range(5):
        print(a[i][j])
# def s(param):
#
#     result = []
#     m = []
#     t = 0
#     p = 0
#
#     for t in param:
#         if t == 'INT':
#             if p == 0:
#                 result.append('#' * 8)
#                 t += 8
#             else:
#                 result.append(solve(m))
#                 result.append('#' * 8)
#                 m = []
#                 t += 16
#         if t == 'LONG':
#             if p == 0:
#                 result.append('#' * 8)
#                 result.append('#' * 8)
#                 t += 16
#             else:
#                 result.append(solve(m))
#                 result.append('#' * 8)
#                 result.append('#' * 8)
#                 t += 24
#
#         if t == 'FLOAT':
#             if p == 0:
#                 m += ['#' for _ in range(4)]
#                 p = 4
#             elif p == 4:
#                 result.append(''.join(m) + ('#' * 4))
#                 t += 8
#                 m =[]
#             else:
#                 result.append(solve(m))
#                 m = []
#                 t += 8
#         if t == 'SHORT':


def solve(m):
    return ''.join(m) + ('.' * (len(m) - 1))

