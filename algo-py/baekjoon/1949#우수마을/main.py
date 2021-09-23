import sys


def solution(graph, cost, n):
    v = [0] * (n + 1)
    dp = [[0, 0] for _ in range(n + 1)]

    def find(node):
        for child in graph[node]:
            if v[child]:
                continue
            v[child] = 1
            find(child)
            dp[node][0] += dp[child][1]
            dp[node][1] += max(dp[child][0], dp[child][1])
        dp[node][0] += cost[node]

    v[1] = 1
    find(1)
    return max(dp[1][0], dp[1][1])


if __name__ == '__main__':
    input = sys.stdin.readline
    sys.setrecursionlimit(int(10e8))
    n = int(input())
    g = [[] for _ in range(n + 1)]
    c = [0]+list(map(int, input().split()))
    for _ in range(n-1):
        u, v = map(int, input().split())
        g[u].append(v)
        g[v].append(u)
    print(solution(g, c, n))
