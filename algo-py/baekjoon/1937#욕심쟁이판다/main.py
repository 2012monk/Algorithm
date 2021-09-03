import sys


def solution(board, n):
    v = [[0 for _ in range(n)] for _ in range(n)]

    def dfs(i, j): # dfs로 모든 경로 탐색
        if v[i][j]:  # 중복 탐색 방지및 결과 기록
            return v[i][j]
        r = []
        for dx, dy in zip([0, 0, 1, -1], [1, -1, 0, 0]):
            x, y = i + dx, j + dy
            if 0 <= x < n and 0 <= y < n and board[i][j] < board[x][y]:
                r.append(dfs(x, y))
        v[i][j] = max(r, default=0) + 1
        return v[i][j]

    return max((dfs(i, j) for i in range(n) for j in range(n)))  # 가능한 경로중 가장큰값


if __name__ == '__main__':
    input = sys.stdin.readline
    sys.setrecursionlimit(1 << 20)
    n = int(input())
    b = [list(map(int, input().split())) for _ in range(n)]
    print(solution(b, n))
