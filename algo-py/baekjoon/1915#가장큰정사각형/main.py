import sys


def solution(d,n,m):
    mx = 0
    for i in range(1,n+1):
        for j in range(1,m+1):
            if d[i][j] and (x:=min(d[i-1][j],d[i][j-1],d[i-1][j-1])) > 0:
                d[i][j] = x + 1
            if mx < d[i][j]:
                mx=d[i][j]

    return mx*mx


if __name__ == '__main__':
    input = sys.stdin.readline
    n,m=map(int,input().split())
    b=[[0] + list(map(int, list(input().strip()))) for _ in range(n)]
    b.insert(0, [0]*(m+1))
    print(solution(b,n,m))

