import sys


def find(x):
    if uf[x] < 0:
        return x
    uf[x] = find(uf[x])
    return uf[x]


def dock(port):
    a, b = map(find, (port, port - 1))
    if a < b:
        a, b = b, a
    uf[a] = b


input = sys.stdin.readline

if __name__ == '__main__':
    g = int(input())
    p = int(input())
    uf = [-1] * (g + 1)  # 비어있는 게이트 (독립집합) 는 -1 로 표시
    planes = [int(input()) for _ in range(p)]

    r = 0
    for pl in planes:
        next_gate = find(pl)  # 다음 으로 들어갈 수 있는 게이트를 찾는다
        if next_gate == 0:  # g(i) 번 이하 게이트는 가득 찼다
            break
        dock(next_gate)  # 게이트가 사용되었음을 표시
        r += 1
    print(r)
