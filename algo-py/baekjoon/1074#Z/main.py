# n^2 x n^2 배열에서 주어진 i,j 가 몇번인지 찾는다
# 사분면으로 나눈후 재귀로 접근

def find(n, i, j):
    if n == 0:  # base condition
        return 0
    n -= 1
    h = 1 << n
    # 탐색범위를 나누어 재귀호출
    if i < h and j < h:  # 1 사분면
        return find(n, i, j)
    if i < h <= j:  # 2 사분면
        return h * h + find(n , i, j - h)
    if i >= h > j:  # 3 사분면
        return h * h * 2 + find(n , i - h, j)
    # 4 사분면
    return h * h * 3 + find(n, i - h, j - h)


if __name__ == '__main__':
    print(find(*map(int, input().split())))
