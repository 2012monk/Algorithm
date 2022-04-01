import heapq
import sys

input = sys.stdin.readline


def solution_pq():
    n = int(input())
    q = list(map(int, input().split()))
    heapq.heapify(q)
    for _ in range(n - 1):
        arr = list(map(int, input().split()))
        for a in arr:
            if q[0] < a:
                heapq.heappop(q)
                heapq.heappush(q, a)
    print(q[0])


solution_pq()


# 정렬 풀이
def solution_sort():
    n = int(input())
    q = list(map(int, input().split()))
    q.sort(reverse=True)
    for _ in range(n - 1):
        arr = list(map(int, input().split()))
        for a in arr:
            if q[-1] < a:
                q.pop()
                q.append(a)
                q.sort(reverse=True)
    print(q[-1])
