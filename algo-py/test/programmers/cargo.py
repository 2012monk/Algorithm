import heapq


def solution(a, b, g, s, w, t):
    n = len(g)
    time = 0
    q = [(t[i], i) for i in range(n)]
    print(q)
    heapq.heapify(q)
    while a > 0 or b > 0:
        print(a, b, g, s, w, t, time)
        eta, i = heapq.heappop(q)
        if eta <= time:
            heapq.heappush(q, (eta, i))
        else:
            time += 1
            heapq.heappush(q, (eta+2*t[i], i))

        weight = w[i]
        if a > 0 and g[i] > 0:
            c = min(a, g[i], weight)
            a -= c
            g[i] -= c
            weight -= c
        if b > 0 and s[i] > 0:
            c = min(b, s[i], weight)
            b -= c
            s[i] -= c
            weight -= c
        if a == 0 and b == 0:
            break
    return time


print(solution(10, 10, [100], [100], [7], [10]))
print(solution(90, 500, [70, 70, 0], [0, 0, 500], [100, 100, 2], [4, 8, 1]))

# def solution(a, b, g, s, w, t):
#     n = len(g)
#     time = 0
#     cur = t[:]
#     while a > 0 or b > 0:
#         for i in range(n):
#             if (time // (cur[i])) % 2 == 0:
#                 continue
#             cur[i] += 2*t[i]
#             weight = w[i]
#             if a > 0 and g[i] > 0:
#                 c = min(a, g[i], weight)
#                 a -= c
#                 g[i] -= c
#                 weight -= c
#             if b > 0 and s[i] > 0:
#                 c = min(b, s[i], weight)
#                 b -= c
#                 s[i] -= c
#                 weight -= c
#
#         time += 1
#
#     return time-1