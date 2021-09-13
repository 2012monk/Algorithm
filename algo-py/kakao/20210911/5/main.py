from collections import defaultdict


def solution(info, edges):
    g = defaultdict(list)
    for u, v in edges:
        g[u].append(v)
        # g[v].append(u)

    dp = [0 for _ in range(len(info))]

    def find(n, s, w):
        if n not in g:
            return s,-1

        if s <= w:
            return s, w
        t = []
        for i in g[n]:
            t.append(find(i, s + (info[n] ^ 1), w + info[n]))


    for d in dp:
        print(d)
    # print(dp)
    answer = 0
    return answer


print(solution([0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0],
               [[0, 1], [0, 2], [1, 3], [1, 4], [2, 5], [2, 6], [3, 7], [4, 8], [6, 9], [9, 10]]))
